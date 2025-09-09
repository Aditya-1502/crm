package com.jsp.crm.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.jsp.crm.model.AdminConfig;
import com.jsp.crm.model.Coating;
import com.jsp.crm.model.Dispatch;
import com.jsp.crm.model.DispatchApprovalNote;
import com.jsp.crm.model.Extrusion;
import com.jsp.crm.model.FinalInspectionHeader;
import com.jsp.crm.model.FinalInspectionRow;
import com.jsp.crm.model.Inspection;
import com.jsp.crm.model.Jointing;
import com.jsp.crm.model.Mixing;
import com.jsp.crm.model.Moulding;
import com.jsp.crm.model.Order;
import com.jsp.crm.model.Packing;
import com.jsp.crm.model.Planning;
import com.jsp.crm.model.Production;
import com.jsp.crm.model.QcSupervisor;
import com.jsp.crm.model.Reports;
import com.jsp.crm.model.Search;
import com.jsp.crm.model.Sheeting;
import com.jsp.crm.repository.AdminConfigRepository;
import com.jsp.crm.repository.CmrRepository;
import com.jsp.crm.repository.CoatingRepository;
import com.jsp.crm.repository.DispatchApprovalNoteRepository;
import com.jsp.crm.repository.DispatchRepository;
import com.jsp.crm.repository.ExtrusionRepository;
import com.jsp.crm.repository.FinalInspectionHeaderRepository;
import com.jsp.crm.repository.FinalInspectionRowRepository;
import com.jsp.crm.repository.InspectionRepository;
import com.jsp.crm.repository.JointingRepository;
import com.jsp.crm.repository.MixRepository;
import com.jsp.crm.repository.MouldRepository;
import com.jsp.crm.repository.OrderRepository;
import com.jsp.crm.repository.PackingRepository;
import com.jsp.crm.repository.PlanningRepository;
import com.jsp.crm.repository.ProdRepository;
import com.jsp.crm.repository.QcRepository;
import com.jsp.crm.repository.SheetingRepository;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class CrmController {

	@Autowired
	CmrRepository repository;

	@Autowired
	MixRepository mrepository;

	@Autowired
	ProdRepository prepository;

	@Autowired
	OrderRepository orepository;

	@Autowired
	ExtrusionRepository erepository;

	@Autowired
	CoatingRepository crepository;

	@Autowired
	JointingRepository jrepository;

	@Autowired
	MouldRepository mouldrepository;

	@Autowired
	SheetingRepository sheetrepository;

	@Autowired
	QcRepository qcrepository;

	@Autowired
	PlanningRepository planrepository;

	@Autowired
	InspectionRepository insrepository;

	@Autowired
	PackingRepository packrepository;

	@Autowired
	DispatchRepository disrepository;

	@Autowired
	private FinalInspectionHeaderRepository headerRepo;

	@Autowired
	private FinalInspectionRowRepository rowRepo;

	@Autowired
	private DispatchApprovalNoteRepository dispatchRepo;

	@Autowired
	JavaMailSender mailSender;
	
	@Autowired
	private AdminConfigRepository adminConfigRepository;

//	@Value("${root.email}")
//	private String rootEmail;
	@Value("${CLOUDINARY_URL}")
	private String cloudinaryUrl;

	private Cloudinary cloudinary;

	@PostConstruct
	public void init() {
		cloudinary = new Cloudinary(cloudinaryUrl);
	}

//	@GetMapping("/")
//	public String load() {
//		return "index.html";
//	}
	@GetMapping("/admin-settings")
	public String loadsettings() {
		return "admin-settings.html";
	}
	@GetMapping({ "/", "/admin/login" })
	public String load() {
		return "admin-login.html";
	}
	private String getRootEmail() {
	    return adminConfigRepository.findById(1L).get().getEmail();
	}
//	@PostMapping("/")
//	public String admin(@RequestParam String username, @RequestParam String password, HttpSession session,
//			ModelMap map) {
//		if (username.equals("admin")) {
//			if (password.equals("admin")) {
//				session.setAttribute("admin", "admin");
//				map.put("pass", "Login succes");
//				return "redirect:/dashboard";
//			} else {
//				map.put("fail", "Login failed");
//				return "index.html";
//			}
//		} else {
//			map.put("fail", "Enter proper Email");
//			return "index.html";
//		}
//	}

//	@PostMapping("/admin/send-otp")
//	public String sendOtp(@RequestParam String email, ModelMap map, HttpSession session) {
//		if (rootEmail.equals(email)) {
//			int otp = new Random().nextInt(100000, 1000000);
//			sendEmail(email, otp);
//			session.setAttribute("otp", otp);
//			return "redirect:/admin/otp";
//		} else {
//			session.setAttribute("fail", "Invalid Email, check your email");
//			return "redirect:/";
//		}
//	}
	@PostMapping("/admin/send-otp")
	public String sendOtp(@RequestParam String email, HttpSession session) {
	    if (getRootEmail().equals(email)) {
	        int otp = new Random().nextInt(100000, 1000000);
	        sendEmail(email, otp);   // your existing sendEmail method
	        session.setAttribute("otp", otp);
	        return "redirect:/admin/otp";
	    } else {
	        session.setAttribute("fail", "Invalid Email");
	        return "redirect:/";
	    }
	}
	void sendEmail(String email, int otp) {
		try {
			SimpleMailMessage message2 = new SimpleMailMessage();
			message2.setTo(email);
			message2.setText("Your Otp for Logging in is : " + otp);
			message2.setSubject("OTP for Logging in into CRM");
			mailSender.send(message2);
			System.out.println("OTP is : " + otp);
		} catch (Exception e) {
			System.out.println("OTP is : " + otp);
		}
	}

	@GetMapping("/admin/otp")
	public String otp() {
		return "admin-otp.html";
	}

//	@PostMapping("/admin/verify-otp")
//	public String otp(@RequestParam int otp, HttpSession session) {
//		int otpInSession = (int) session.getAttribute("otp");
//		if (otp == otpInSession) {
//			session.setAttribute("admin", true);
//			session.setAttribute("pass", "Login Success as Admin");
//			return "redirect:/admin/home";
//		} else {
//			session.setAttribute("fail", "Invalid OTP");
//			return "redirect:/admin/otp";
//		}
//	}
	@PostMapping("/admin/verify-otp")
	public String verifyOtp(@RequestParam int otp, HttpSession session) {
	    int otpInSession = (int) session.getAttribute("otp");
	    if (otp == otpInSession) {
	        session.setAttribute("admin", true);
	        session.setAttribute("pass", "Login Success as Admin");
	        return "redirect:/admin/home";
	    } else {
	        session.setAttribute("fail", "Invalid OTP");
	        return "redirect:/admin/otp";
	    }
	}

//	@PostMapping("/admin/resend-otp")
//	public String resendOtp(HttpSession session) {
//		int otp = new Random().nextInt(100000, 1000000);
//		sendEmail(this.rootEmail, otp);
//		session.setAttribute("otp", otp);
//		session.setAttribute("pass", "OTP Resend Successfully");
//		return "redirect:/admin/otp";
//	}
	@PostMapping("/admin/resend-otp")
	public String resendOtp(HttpSession session) {
	    String rootEmail = getRootEmail(); // Make sure this works!

	    if (rootEmail == null || rootEmail.isEmpty()) {
	        session.setAttribute("fail", "Root email not configured. Contact support.");
	        return "redirect:/admin/otp";
	    }

	    int otp = new Random().nextInt(100000, 1000000);
	    sendEmail(rootEmail, otp); // keep your method
	    session.setAttribute("otp", otp);
	    session.setAttribute("pass", "OTP Resent Successfully");

	    return "redirect:/admin/otp";
	}

	
	@GetMapping("/admin/settings")
	public String settings(ModelMap map) {
	    map.put("rootEmail", getRootEmail());
	    return "admin-settings"; // admin-settings.html
	}

	@PostMapping("/admin/update-email")
	public String updateEmail(@RequestParam String email) {
	    AdminConfig config = adminConfigRepository.findById(1L).get();
	    config.setEmail(email);      // update dynamically
	    adminConfigRepository.save(config);
	    return "redirect:/admin/settings";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
//		 session.invalidate();
		session.removeAttribute("admin");
		session.setAttribute("pass", "Logout Successfully");
		return "redirect:/";
	}

	@GetMapping({ "/admin/home", "/dashboard" })
	public String dashboard(ModelMap model, HttpSession session) {
		int todaysOrder = orepository.findByDate(LocalDate.now()).size();
		long totalOrders = orepository.count(); // this counts rows in table

		int todaysMixing = mrepository.findByDate(LocalDate.now()).size(); // or Date.valueOf(LocalDate.now()) if using
																			// java.sql.Date
		long totalMixings = mrepository.count();

		int todaysProd = prepository.findByDate(LocalDate.now()).size(); // or Date.valueOf(LocalDate.now()) if using
																			// java.sql.Date
		long totalProd = prepository.count();

		int todaysext = erepository.findByDate(LocalDate.now()).size(); // or Date.valueOf(LocalDate.now()) if using
																		// java.sql.Date
		long totalext = erepository.count();

		int todayscoat = crepository.findByDate(LocalDate.now()).size(); // or Date.valueOf(LocalDate.now()) if using
																			// java.sql.Date
		long totalcoat = crepository.count();

		int todaysjoint = jrepository.findByDate(LocalDate.now()).size(); // or Date.valueOf(LocalDate.now()) if using
																			// java.sql.Date
		long totaljoint = jrepository.count();

		int todaysmould = mouldrepository.findByDate(LocalDate.now()).size(); // or Date.valueOf(LocalDate.now()) if
																				// using java.sql.Date
		long totalmould = mouldrepository.count();

		int todayssheet = sheetrepository.findByDate(LocalDate.now()).size(); // or Date.valueOf(LocalDate.now()) if
																				// using java.sql.Date
		long totalsheet = sheetrepository.count();

		int todaysins = insrepository.findByDate(LocalDate.now()).size(); // or Date.valueOf(LocalDate.now()) if using
																			// java.sql.Date
		long totalins = insrepository.count();

		int todaysqcsuper = qcrepository.findByDate(LocalDate.now()).size(); // or Date.valueOf(LocalDate.now()) if
																				// using java.sql.Date
		long totalqcsuper = qcrepository.count();

		int todaysplanning = planrepository.findByDate(LocalDate.now()).size(); // or Date.valueOf(LocalDate.now()) if
																				// using java.sql.Date
		long totalplanning = planrepository.count();

		int todayspack = packrepository.findByDate(LocalDate.now()).size(); // or Date.valueOf(LocalDate.now()) if using
																			// java.sql.Date
		long totalpack = packrepository.count();

		int todaysdis = disrepository.findByDate(LocalDate.now()).size(); // or Date.valueOf(LocalDate.now()) if using
																			// java.sql.Date
		long totaldis = disrepository.count();
		model.put("totalOrders", todaysOrder);
		model.put("totalMixings", todaysMixing);
		model.put("totalProd", todaysProd);
		model.put("totalext", todaysext);
		model.put("totalcoat", todayscoat);
		model.put("totaljoint", todaysjoint);
		model.put("totalmould", todaysmould);
		model.put("totalsheet", todayssheet);
		model.put("totalins", todaysins);
		model.put("totalqcsuper", todaysqcsuper);
		model.put("totalplanning", todaysplanning);
		model.put("totalpack", todayspack);
		model.put("totaldis", todaysdis);
		if (session.getAttribute("admin") != null) {
			return "dashboard.html";
		} else {
			session.setAttribute("fail", "Invalid Session");
			return "redirect:/";
		}
		// make sure this matches the HTML file name
	}

	@GetMapping("/search")
	public String search(HttpSession session) {
		if (session.getAttribute("admin") != null) {
			return "search.html";
		} else {
			session.setAttribute("fail", "Invalid Session");
			return "redirect:/logout";
		}

	}

	@GetMapping("/reports")
	public String loadAdd(Reports reports, HttpSession session) {
		if (session.getAttribute("admin") != null) {
			return "reports.html";
		} else {
			session.setAttribute("fail", "Invalid Session");
			return "redirect:/";
		}
	}

	@PostMapping("/reports-draft")
	public String reportDraft(@ModelAttribute Reports report, ModelMap map, HttpSession session) {
		session.setAttribute("report", report);
		map.put("message", "reports added to draft");
		return "reports.html";
	}

	@PostMapping("/reports")
	public String add(@ModelAttribute Reports report, ModelMap map) {
		repository.save(report);
		map.put("message", "reports added succesfully");
		return "redirect:/vreports";
	}

	@GetMapping("/vreports")
	public String viewReports(ModelMap map) {
		List<Reports> list = repository.findAll();
		map.put("list", list);
		return "report_fetch.html";
	}

	@GetMapping("/download-excel")
	public void downloadExcel(HttpServletResponse response) throws IOException {
		List<Reports> reports = repository.findAll();

		Workbook workbook = new XSSFWorkbook();
		org.apache.poi.ss.usermodel.Sheet sheet = workbook.createSheet("Reports");

		Row header = sheet.createRow(0);
		header.createCell(0).setCellValue("ID");
		header.createCell(1).setCellValue("Start Date");
		header.createCell(2).setCellValue("End Date");
		header.createCell(3).setCellValue("Customer Name");
		header.createCell(4).setCellValue("Contact No");
		header.createCell(5).setCellValue("Company Name");
		header.createCell(6).setCellValue("Responsible Person");
		header.createCell(7).setCellValue("Task Maker");

		int rowCount = 1;
		for (Reports report : reports) {
			Row row = sheet.createRow(rowCount++);
			row.createCell(0).setCellValue(report.getId());
			row.createCell(1).setCellValue(report.getStartDate().toString());
			row.createCell(2).setCellValue(report.getEndDate().toString());
			row.createCell(3).setCellValue(report.getCustomerName());
			row.createCell(4).setCellValue(report.getCustomerNo());
			row.createCell(5).setCellValue(report.getComponentName());
			row.createCell(6).setCellValue(report.getResponsiblePerson());
			row.createCell(7).setCellValue(report.getToolMaker());
		}

		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setHeader("Content-Disposition", "attachment; filename=reports.xlsx");

		workbook.write(response.getOutputStream());
		workbook.close();
	}

//	@GetMapping("/edit")
//	public String edit(@RequestParam int id , ModelMap map) {
//		
//		Reports m=repository.findById(id).get();
//		map.put("m",m);
//		return "edit.html";
//	}
	@GetMapping("/order")
	public String order(ModelMap map,HttpSession session) {
		
		    Order last = orepository.findTopByOrderByIdDesc();
		    String routeCard = last == null ? "RC00001"
		                                    : "RC" + String.format("%05d", Integer.parseInt(last.getRouteCardNo().substring(2)) + 1);

		    map.put("orderLog", new Order()); // empty object for form binding
		    map.put("routeCard", routeCard);     // send route card separately
		    if (session.getAttribute("admin") != null) {
		    	return "orderlog.html";
			} else {
				session.setAttribute("fail", "Invalid Session");
				return "redirect:/logout";
			}
		
	}

	@PostMapping("/order")
	public String addOrder(@ModelAttribute Order order, ModelMap map) {
		try {
			MultipartFile file = order.getImageFile();

			if (file != null && !file.isEmpty()) {
				Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
				String imageUrl = (String) uploadResult.get("secure_url");
				order.setImageUrl(imageUrl); // Save to DB
			}

			orepository.save(order);
			map.put("msg", "Order added successfully");
			return "redirect:/mixing";

		} catch (Exception e) {
			e.printStackTrace();
			map.put("error", "Something went wrong");
			return "errorPage";
		}
	}

//	@PostMapping("/orders-draft")
//	public String orderDraft(@ModelAttribute Order order, ModelMap map, HttpSession session) {
//		session.setAttribute("order", order);
//		map.put("message", "order added to draft");
//		return "orderlog.html";
//	}

	@GetMapping("/export-order-log")
	public void exportOrderLog(HttpServletResponse response) throws IOException {
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setHeader("Content-Disposition", "attachment; filename=order_log.xlsx");

		List<Order> orderLogs = orepository.findAll();

		Workbook workbook = new XSSFWorkbook();
		org.apache.poi.ss.usermodel.Sheet sheet = workbook.createSheet("OrderLog");

		Row header = sheet.createRow(0);
		String[] columns = { "ID", "Route Card No", "Date", "Component Name", "Customer No", "Enquiry No",
				"Quotation No", "Purchase Order", "Formulation No", "Method", "Material", "Tool/Die No", "Weight/Meter",
				"Temperature", "RPM Extruder", "RPM Conveyor", "No. of Cavity", "Planned Qty", "Work Order No",
				"Coating", "Tool Status", "Responsible Person", "Tool Maker", "ETA", "Drawing/Image" };

		for (int i = 0; i < columns.length; i++) {
			header.createCell(i).setCellValue(columns[i]);
		}

		int rowIdx = 1;
		for (Order log : orderLogs) {
			Row row = sheet.createRow(rowIdx++);
			row.createCell(0).setCellValue(log.getId());
			row.createCell(1).setCellValue(log.getRouteCardNo());
			row.createCell(2).setCellValue(log.getDate() != null ? log.getDate().toString() : "");
			row.createCell(3).setCellValue(log.getComponentName());
			row.createCell(4).setCellValue(log.getCustomerNo());
			row.createCell(5).setCellValue(log.getEnquiryNo());
			row.createCell(6).setCellValue(log.getQuotationNo());
			row.createCell(7).setCellValue(log.getPurchaseOrder());
			row.createCell(8).setCellValue(log.getFormulationNo());
			row.createCell(9).setCellValue(log.getMethod());
			row.createCell(10).setCellValue(log.getMaterial());
			row.createCell(11).setCellValue(log.getToolDieNo());
			row.createCell(12).setCellValue(log.getWeightPerMeter() != null ? log.getWeightPerMeter() : 0);
			row.createCell(13).setCellValue(log.getTemperature() != null ? log.getTemperature() : 0);
			row.createCell(14).setCellValue(log.getExtruderRpm() != null ? log.getExtruderRpm() : 0);
			row.createCell(15).setCellValue(log.getConveyorRpm() != null ? log.getConveyorRpm() : 0);
			row.createCell(16).setCellValue(log.getNoOfCavity() != null ? log.getNoOfCavity() : 0);
			row.createCell(17).setCellValue(log.getPlannedQty() != null ? log.getPlannedQty() : 0);
			row.createCell(18).setCellValue(log.getWorkOrderNo());
			row.createCell(19).setCellValue(log.getCoating());
			row.createCell(20).setCellValue(log.getToolStatus());
			row.createCell(21).setCellValue(log.getResponsiblePerson());
			row.createCell(22).setCellValue(log.getToolMaker());
			row.createCell(23).setCellValue(log.getEta() != null ? log.getEta().toString() : "");

		}

		workbook.write(response.getOutputStream());
		workbook.close();
	}

	@GetMapping("/mixing")
	public String mix(ModelMap map,HttpSession session) {
		map.put("order", new Order()); // ✅ Put empty object to avoid Thymeleaf null error
		map.put("production", new Production());
		map.put("extrusion", new Extrusion());
		 if (session.getAttribute("admin") != null) {
			 return "mixing.html";
			} else {
				session.setAttribute("fail", "Invalid Session");
				return "redirect:/logout";
			}
		
		
	}

	@PostMapping("/mixing")
	public String addMix(@ModelAttribute Mixing mix, ModelMap map) {
		mrepository.save(mix);
		map.put("message", "reports added succesfully");
		return "redirect:/production";
	}

	@GetMapping("/vmixing")
	public String viewMixing(ModelMap map) {
		List<Mixing> list = mrepository.findAll();
		map.put("list", list);
		return "mixing_fetch.html";
	}

	@GetMapping("/export-mixing")
	public void exportMixingData(HttpServletResponse response) throws IOException {
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setHeader("Content-Disposition", "attachment; filename=mixing.xlsx");

		List<Mixing> mixingList = mrepository.findAll();

		Workbook workbook = new XSSFWorkbook();
		org.apache.poi.ss.usermodel.Sheet sheet = workbook.createSheet("Mixing");

		Row header = sheet.createRow(0);
		String[] columns = { "ID", "Route Card No", "Date", "Batch No", "Hardness", "Sheet Thickness", "Lot No",
				"Formulation Code", "Batch Weight", "Colour", "Mixing By" };

		for (int i = 0; i < columns.length; i++) {
			header.createCell(i).setCellValue(columns[i]);
		}

		int rowIdx = 1;
		for (Mixing mix : mixingList) {
			Row row = sheet.createRow(rowIdx++);
			row.createCell(0).setCellValue(mix.getId());
			row.createCell(1).setCellValue(mix.getRouteCardNo());
			row.createCell(2).setCellValue(mix.getDate().toString());
			row.createCell(3).setCellValue(mix.getBatchNo());
			row.createCell(4).setCellValue(mix.getHardness());
			row.createCell(5).setCellValue(mix.getSheetThickness());
			row.createCell(6).setCellValue(mix.getLotNo());
			row.createCell(7).setCellValue(mix.getFormulationNo());
			row.createCell(8).setCellValue(mix.getBatchWeight());
			row.createCell(9).setCellValue(mix.getColour());
			row.createCell(10).setCellValue(mix.getMixingBy());
		}

		workbook.write(response.getOutputStream());
		workbook.close();
	}

	@GetMapping("/production")
	public String prod(ModelMap map,HttpSession session) {
		map.put("order", new Order()); // prevent Thymeleaf error on first load
		map.put("production", new Production());
		map.put("extrusion", new Extrusion());
		map.put("mixing", new Mixing());
		 if (session.getAttribute("admin") != null) {
			 return "production.html";
			} else {
				session.setAttribute("fail", "Invalid Session");
				return "redirect:/logout";
			}
	}

	@PostMapping("/production")
	public String addProd(@ModelAttribute Production prod, ModelMap map) {
		prepository.save(prod);
		map.put("message", "products added succesfully");
		return "redirect:/extrusion";
	}

	@GetMapping("/export-supervisor-report")
	public void exportSupervisorReport(HttpServletResponse response) throws IOException {
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setHeader("Content-Disposition", "attachment; filename=production_supervisor.xlsx");

		List<Production> data = prepository.findAll();

		Workbook workbook = new XSSFWorkbook();
		org.apache.poi.ss.usermodel.Sheet sheet = workbook.createSheet("Supervisor Report");

		Row header = sheet.createRow(0);
		String[] columns = { "ID", "Route Card No", "Date", "Component Name", "Customer No", "Method", "Enquiry No",
				"Material", "Quotation No", "Tool/Die No", "Batch No", "Batch Weight", "Extruder RPM", "DC Oven Temp",
				"Weight/Meter", "Production Per Hour", "Conveyor RPM", "Setup Tool/Die No", "No. of Cavity", "Time",
				"Clamp Pressure", "Cycle Time", "Curing Temp", "Machine" };

		for (int i = 0; i < columns.length; i++) {
			header.createCell(i).setCellValue(columns[i]);
		}

		int rowIdx = 1;
		for (Production ps : data) {
			Row row = sheet.createRow(rowIdx++);
			row.createCell(0).setCellValue(ps.getId());
			row.createCell(1).setCellValue(ps.getRouteCardNo());
			row.createCell(2).setCellValue(ps.getDate() != null ? ps.getDate().toString() : "");
			row.createCell(3).setCellValue(ps.getComponentName());
			row.createCell(4).setCellValue(ps.getCustomerNo() != null ? ps.getCustomerNo() : 0);
			row.createCell(5).setCellValue(ps.getMethod());
			row.createCell(6).setCellValue(ps.getEnquiryNo());
			row.createCell(7).setCellValue(ps.getMaterial());
			row.createCell(8).setCellValue(ps.getQuotationNo());
			row.createCell(9).setCellValue(ps.getToolDieNo());
			row.createCell(10).setCellValue(ps.getBatchNo());
			row.createCell(11).setCellValue(ps.getBatchWeight() != null ? ps.getBatchWeight() : 0);
			row.createCell(12).setCellValue(ps.getExtruderRPM() != null ? ps.getExtruderRPM() : 0);
			row.createCell(13).setCellValue(ps.getDcOvenTemp() != null ? ps.getDcOvenTemp() : 0);
			row.createCell(14).setCellValue(ps.getWeightPerMeter() != null ? ps.getWeightPerMeter() : 0);
			row.createCell(15).setCellValue(ps.getProductionPerHour() != null ? ps.getProductionPerHour() : 0);
			row.createCell(16).setCellValue(ps.getConveyorRPM() != null ? ps.getConveyorRPM() : 0);
			row.createCell(17).setCellValue(ps.getSetupToolDieNo() != null ? ps.getSetupToolDieNo() : 0);
			row.createCell(18).setCellValue(ps.getNoOfCavity() != null ? ps.getNoOfCavity() : 0);
			row.createCell(19).setCellValue(ps.getTime());
			row.createCell(20).setCellValue(ps.getClampPressure() != null ? ps.getClampPressure() : 0);
			row.createCell(21).setCellValue(ps.getCycleTime() != null ? ps.getCycleTime() : 0);
			row.createCell(22).setCellValue(ps.getCuringTemp() != null ? ps.getCuringTemp() : 0);
			row.createCell(23).setCellValue(ps.getMachine());
		}

		workbook.write(response.getOutputStream());
		workbook.close();
	}

	@GetMapping("/vproduction")
	public String viewProd(ModelMap map) {
		List<Production> list = prepository.findAll();
		map.put("list", list);
		return "production_fetch.html";
	}

	@GetMapping("/extrusion")
	public String extrusion(ModelMap map) {
		map.put("order", new Order());
		return "extrusion.html";
	}

	@PostMapping("/extrusion")
	public String addex(@ModelAttribute Extrusion ex, ModelMap map) {
		erepository.save(ex);
		map.put("message", " added succesfully");
		return "redirect:/jointing";
	}

	@GetMapping("/export-extrusion-report")
	public void exportExtrusionReport(HttpServletResponse response) throws IOException {
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setHeader("Content-Disposition", "attachment; filename=extrusion_report.xlsx");

		List<Extrusion> list = erepository.findAll();

		Workbook workbook = new XSSFWorkbook();
		org.apache.poi.ss.usermodel.Sheet sheet = workbook.createSheet("Extrusion Report");

		Row header = sheet.createRow(0);
		String[] columns = { "ID", "Route Card No", "Date", "Component Name", "Customer No", "Method", "Enquiry No",
				"Material", "Quotation No", "Tool Die No", "Batch No", "Batch Weight", "Balance Weight", "Extruder RPM",
				"DC Oven Temp", "Weight/Meter", "Production/Hour", "Conveyor RPM", "Setup Tool Die No", "No. of Cavity",
				"Time", "Clamp Pressure", "Cycle Time", "Curing Temp", "Machine", "Extrusion Date", "Start Time",
				"End Time", "Planned Qty", "Processed Qty", "OK Qty", "Not OK Qty", "Operator Name", "Jointing",
				"Remark", "Received Qty", "Post Processed Qty", "Temperature" };

		for (int i = 0; i < columns.length; i++) {
			header.createCell(i).setCellValue(columns[i]);
		}

		int rowIdx = 1;
		for (Extrusion e : list) {
			Row row = sheet.createRow(rowIdx++);
			row.createCell(0).setCellValue(e.getId());
			row.createCell(1).setCellValue(e.getRouteCardNo());
			row.createCell(2).setCellValue(e.getDate());
			row.createCell(3).setCellValue(e.getComponentName());
			row.createCell(4).setCellValue(e.getCustomerNo());
			row.createCell(5).setCellValue(e.getMethod());
			row.createCell(6).setCellValue(e.getEnquiryNo());
			row.createCell(7).setCellValue(e.getMaterial());
			row.createCell(8).setCellValue(e.getQuotationNo());
			row.createCell(9).setCellValue(e.getToolDieNo());

			row.createCell(10).setCellValue(e.getBatchNo());
			row.createCell(11).setCellValue(e.getBatchWeight());
			row.createCell(12).setCellValue(e.getBalanceWeight());

			row.createCell(13).setCellValue(e.getExtruderRPM());
			row.createCell(14).setCellValue(e.getDcOvenTemp());
			row.createCell(15).setCellValue(e.getWeightPerMeter());
			row.createCell(16).setCellValue(e.getProductionPerHour());
			row.createCell(17).setCellValue(e.getConveyorRPM());
			row.createCell(18).setCellValue(e.getSetupToolDieNo());
			row.createCell(19).setCellValue(e.getNoOfCavity());
			row.createCell(20).setCellValue(e.getTime());
			row.createCell(21).setCellValue(e.getClampPressure());
			row.createCell(22).setCellValue(e.getCycleTime());
			row.createCell(23).setCellValue(e.getCuringTemp());
			row.createCell(24).setCellValue(e.getMachine());

			row.createCell(25).setCellValue(e.getExtrusionDate());
			row.createCell(26).setCellValue(e.getStartTime());
			row.createCell(27).setCellValue(e.getEndTime());
			row.createCell(28).setCellValue(e.getPlannedQty());
			row.createCell(29).setCellValue(e.getProcessedQty());
			row.createCell(30).setCellValue(e.getOkQty());
			row.createCell(31).setCellValue(e.getNotOkQty());
			row.createCell(32).setCellValue(e.getOperatorName());
			row.createCell(33).setCellValue(e.getJointing());
			row.createCell(34).setCellValue(e.getRemark());

			row.createCell(35).setCellValue(e.getReceivedQty());
			row.createCell(36).setCellValue(e.getPostProcessedQty());
			row.createCell(37).setCellValue(e.getTemperature());

		}

		workbook.write(response.getOutputStream());
		workbook.close();
	}

	@GetMapping("/coating")
	public String coating(ModelMap map) {
		map.put("order", new Order());
		return "coating.html";
	}

	@PostMapping("/coating")
	public String addCoat(@ModelAttribute Coating coat, ModelMap map) {
		crepository.save(coat);
		map.put("message", " added succesfully");
		return "redirect:/sheeting";
	}

	@GetMapping("/export-coating-report")
	public void exportCoatingReport(HttpServletResponse response) throws IOException {
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setHeader("Content-Disposition", "attachment; filename=coating_report.xlsx");

		List<Coating> list = crepository.findAll();

		Workbook workbook = new XSSFWorkbook();
		org.apache.poi.ss.usermodel.Sheet sheet = workbook.createSheet("Coating Report");

		Row header = sheet.createRow(0);
		String[] columns = { "ID", "Batch No", "Batch Weight", "Route Card No", "Balance Weight", "Extruder RPM",
				"DC Oven Temp", "Weight/Meter", "Production/Hour", "Conveyor RPM", "Tool Die No", "Cavity No", "Time",
				"Clamp Pressure", "Cycle Time", "Curing Temp", "View Drawing", "Coating Date", "Start Time", "End Time",
				"Planned Qty", "Processed Qty", "OK Qty", "Not OK Qty", "Operator Name", "Coating Remarks",
				"Received Qty", "Postcuring Processed Qty", "Postcuring Temp", "Postcuring Start Time",
				"Postcuring End Time", "Postcuring Duration", "Postcuring Remarks" };

		for (int i = 0; i < columns.length; i++) {
			header.createCell(i).setCellValue(columns[i]);
		}

		int rowIdx = 1;
		for (Coating c : list) {
			Row row = sheet.createRow(rowIdx++);
			row.createCell(0).setCellValue(c.getId());
			row.createCell(1).setCellValue(c.getBatchNo());
			row.createCell(2).setCellValue(c.getBatchWeight());
			row.createCell(3).setCellValue(c.getRouteCardNo());
			row.createCell(4).setCellValue(c.getBalanceWeight());

			row.createCell(5).setCellValue(c.getProductionPerHour());
			row.createCell(6).setCellValue(c.getWeightPerMeter());
			row.createCell(7).setCellValue(c.getToolDieNo());
			row.createCell(8).setCellValue(c.getNoOfCavity());
			row.createCell(9).setCellValue(c.getSetupTime()); // previously `getTime()`
			row.createCell(10).setCellValue(c.getClampPressure());
			row.createCell(11).setCellValue(c.getCycleTime());
			row.createCell(12).setCellValue(c.getCuringTemp());
			row.createCell(13).setCellValue(c.getViewDrawing());

			row.createCell(14).setCellValue(c.getDate().toString()); // date formatting if needed
			row.createCell(15).setCellValue(c.getCoatingStartTime());
			row.createCell(16).setCellValue(c.getCoatingEndTime());
			row.createCell(17).setCellValue(c.getPlanned_qty());
			row.createCell(18).setCellValue(c.getProcessed_qty());
			row.createCell(19).setCellValue(c.getOk_qty());
			row.createCell(20).setCellValue(c.getNot_ok_qty());
			row.createCell(21).setCellValue(c.getOperator_name());
			row.createCell(22).setCellValue(c.getCoating_remarks());

			row.createCell(23).setCellValue(c.getReceivedQty());
			row.createCell(24).setCellValue(c.getPostProcessedQty());
			row.createCell(25).setCellValue(c.getTemperature());
			row.createCell(26).setCellValue(c.getPostStartTime());
			row.createCell(27).setCellValue(c.getPostEndTime());
			row.createCell(28).setCellValue(c.getDuration());
			row.createCell(29).setCellValue(c.getPostRemarks());

		}

		workbook.write(response.getOutputStream());
		workbook.close();
	}

	@GetMapping("/jointing")
	public String jointing(ModelMap map) {
		map.put("order", new Order());
		return "jointing.html";
	}

	@PostMapping("/jointing")
	public String addJoint(@ModelAttribute Jointing coat, ModelMap map) {
		jrepository.save(coat);
		map.put("message", " added succesfully");
		return "redirect:/coating";
	}

	@GetMapping("/export-jointing-report")
	public void exportJointingReport(HttpServletResponse response) throws IOException {
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setHeader("Content-Disposition", "attachment; filename=jointing_report.xlsx");

		List<Jointing> list = jrepository.findAll();

		Workbook workbook = new XSSFWorkbook();
		org.apache.poi.ss.usermodel.Sheet sheet = workbook.createSheet("Jointing Report");

		Row header = sheet.createRow(0);
		String[] columns = { "ID", "Batch No", "Batch Weight", "Route Card No", "Balance Weight", "Extruder RPM",
				"Weight/Meter", "Production/Hour", "Conveyor RPM", "Cavity Number", "Tool Die No", "Cycle Time",
				"View Drawing", "Joining Date", "Start Time", "End Time", "Planned Qty", "Processed Qty", "OK Qty",
				"Not OK Qty", "Operator Name", "Remarks", "Received Qty", "Postcuring Processed Qty", "Temperature",
				"Postcuring Start", "Postcuring End", "Duration", "Postcuring Remarks", "Save Draft", "Submit" };

		for (int i = 0; i < columns.length; i++) {
			header.createCell(i).setCellValue(columns[i]);
		}

		int rowIdx = 1;
		for (Jointing j : list) {
			Row row = sheet.createRow(rowIdx++);
			row.createCell(0).setCellValue(j.getId());
			row.createCell(1).setCellValue(j.getBatchNo());
			row.createCell(2).setCellValue(j.getBatchWeight());
			row.createCell(3).setCellValue(j.getRouteCardNo());
			row.createCell(4).setCellValue(j.getBalanceWeight());

			row.createCell(5).setCellValue(j.getProductionPerHour());
			row.createCell(6).setCellValue(j.getWeightPerMeter());
			row.createCell(7).setCellValue(j.getToolDieNo());
			row.createCell(8).setCellValue(j.getNoOfCavity());
			row.createCell(9).setCellValue(j.getSetupTime());
			row.createCell(10).setCellValue(j.getClampPressure());
			row.createCell(11).setCellValue(j.getCycleTime());
			row.createCell(12).setCellValue(j.getCuringTemp());

			row.createCell(13).setCellValue(j.getViewDrawing());
			row.createCell(14).setCellValue(j.getDate().toString()); // or use a formatter

			row.createCell(15).setCellValue(j.getJoiningStartTime());
			row.createCell(16).setCellValue(j.getJoiningEndTime());
			row.createCell(17).setCellValue(j.getPlannedQuantity());
			row.createCell(18).setCellValue(j.getProcessedQuantity());
			row.createCell(19).setCellValue(j.getOkQuantity());
			row.createCell(20).setCellValue(j.getNotOkQuantity());
			row.createCell(21).setCellValue(j.getOperatorName());
			row.createCell(22).setCellValue(j.getJoiningRemarks());

			row.createCell(23).setCellValue(j.getReceivedQty());
			row.createCell(24).setCellValue(j.getPostProcessedQty());
			row.createCell(25).setCellValue(j.getTemperature());
			row.createCell(26).setCellValue(j.getPostStartTime());
			row.createCell(27).setCellValue(j.getPostEndTime());
			row.createCell(28).setCellValue(j.getDuration());
			row.createCell(29).setCellValue(j.getPostRemarks());

		}

		workbook.write(response.getOutputStream());
		workbook.close();
	}

	@GetMapping("/moulding")
	public String moulding(ModelMap map) {
		map.put("order", new Order());
		return "moulding.html";
	}

	@PostMapping("/moulding")
	public String addMould(@ModelAttribute Moulding mould, ModelMap map) {
		mouldrepository.save(mould);
		map.put("message", " added succesfully");
		return "redirect:/extrusion";
	}

	@GetMapping("/export-moulding-report")
	public void exportMouldingReport(HttpServletResponse response) throws IOException {
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setHeader("Content-Disposition", "attachment; filename=moulding_report.xlsx");

		List<Moulding> list = mouldrepository.findAll();

		Workbook workbook = new XSSFWorkbook();
		org.apache.poi.ss.usermodel.Sheet sheet = workbook.createSheet("Moulding Report");

		Row header = sheet.createRow(0);
		String[] columns = { "ID", "Batch No", "Batch Weight", "Route Card No", "Balance Weight", "Production/Hour",
				"Weight Per Piece", "Tool Die No", "No of Cavity", "Setup Time", "Clamp Pressure", "Cycle Time",
				"Curing Temp", "Moulding Date", "Start Time", "End Time", "Planned Qty", "Processed Qty", "OK Qty",
				"Not OK Qty", "Operator Name", "Remark", "Received Qty", "Post Processed Qty", "Post Temp",
				"Post Start", "Post End", "Duration", "Post Remark" };

		for (int i = 0; i < columns.length; i++) {
			header.createCell(i).setCellValue(columns[i]);
		}

		int rowIdx = 1;
		for (Moulding m : list) {
			Row row = sheet.createRow(rowIdx++);
			row.createCell(0).setCellValue(m.getId());
			row.createCell(1).setCellValue(m.getBatchNo());
			row.createCell(2).setCellValue(m.getBatchWeight());
			row.createCell(3).setCellValue(m.getRouteCardNo());
			row.createCell(4).setCellValue(m.getBalanceWeight());

			row.createCell(5).setCellValue(m.getProductionPerHour());
			row.createCell(6).setCellValue(m.getWeightPerPiece());
			row.createCell(7).setCellValue(m.getToolDieNo());
			row.createCell(8).setCellValue(m.getNoOfCavity());
			row.createCell(9).setCellValue(m.getSetupTime());
			row.createCell(10).setCellValue(m.getClampPressure());
			row.createCell(11).setCellValue(m.getCycleTime());
			row.createCell(12).setCellValue(m.getCuringTemp());

			row.createCell(13).setCellValue(m.getDate());
			row.createCell(14).setCellValue(m.getStartTime());
			row.createCell(15).setCellValue(m.getEndTime());
			row.createCell(16).setCellValue(m.getPlannedQty());
			row.createCell(17).setCellValue(m.getProcessedQty());
			row.createCell(18).setCellValue(m.getOkQty());
			row.createCell(19).setCellValue(m.getNotOkQty());
			row.createCell(20).setCellValue(m.getOperatorName());
			row.createCell(21).setCellValue(m.getRemark());

			row.createCell(22).setCellValue(m.getReceivedQty());
			row.createCell(23).setCellValue(m.getPostProcessedQty());
			row.createCell(24).setCellValue(m.getTemperature());
			row.createCell(25).setCellValue(m.getPostStartTime());
			row.createCell(26).setCellValue(m.getPostEndTime());
			row.createCell(27).setCellValue(m.getDuration());
			row.createCell(28).setCellValue(m.getPostRemarks());

		}

		workbook.write(response.getOutputStream());
		workbook.close();
	}

	@GetMapping("/sheeting")
	public String sheeting(ModelMap map) {
		map.put("order", new Order());
		return "sheeting.html";
	}

	@PostMapping("/sheeting")
	public String addSheet(@ModelAttribute Sheeting sheet, ModelMap map) {
		sheetrepository.save(sheet);
		map.put("message", " added succesfully");
		return "redirect:/inspection";
	}

	@GetMapping("/export-sheeting-report")
	public void exportSheetingReport(HttpServletResponse response) throws IOException {
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setHeader("Content-Disposition", "attachment; filename=sheeting_report.xlsx");

		List<Sheeting> list = sheetrepository.findAll();

		Workbook workbook = new XSSFWorkbook();
		org.apache.poi.ss.usermodel.Sheet sheet = workbook.createSheet("Sheeting Report");

		Row header = sheet.createRow(0);
		String[] columns = { "ID", "Batch No", "Batch Weight", "Route Card No", "Balance Weight", "Production/Hour",
				"Setup Time", "Tool Die No", "Curing Temp", "Sheeting Date", "Start Time", "End Time", "Planned Qty",
				"Processed Qty", "OK Qty", "Not OK Qty", "Operator Name", "Sheeting Remark", "Received Qty",
				"Post Processed Qty", "Post Temp", "Post Start", "Post End", "Duration", "Post Remarks" };

		for (int i = 0; i < columns.length; i++) {
			header.createCell(i).setCellValue(columns[i]);
		}

		int rowIdx = 1;
		for (Sheeting s : list) {
			Row row = sheet.createRow(rowIdx++);
			row.createCell(0).setCellValue(s.getId());
			row.createCell(1).setCellValue(s.getBatchNo());
			row.createCell(2).setCellValue(s.getBatchWeight());
			row.createCell(3).setCellValue(s.getRouteCardNo());
			row.createCell(4).setCellValue(s.getBalanceWeight());

			row.createCell(5).setCellValue(s.getProductionPerHour());
			row.createCell(6).setCellValue(s.getSetupTime());
			row.createCell(7).setCellValue(s.getToolDieNo());
			row.createCell(8).setCellValue(s.getCuringTemp());

			row.createCell(9).setCellValue(s.getDate());
			row.createCell(10).setCellValue(s.getSheetingStartTime());
			row.createCell(11).setCellValue(s.getSheetingEndTime());
			row.createCell(12).setCellValue(s.getPlannedQty());
			row.createCell(13).setCellValue(s.getProcessedQty());
			row.createCell(14).setCellValue(s.getOkQty());
			row.createCell(15).setCellValue(s.getNotOkQty());
			row.createCell(16).setCellValue(s.getOperatorName());
			row.createCell(17).setCellValue(s.getSheetingRemark());

			row.createCell(18).setCellValue(s.getReceivedQty());
			row.createCell(19).setCellValue(s.getPostProcessedQty());
			row.createCell(20).setCellValue(s.getTemperature());
			row.createCell(21).setCellValue(s.getPostStartTime());
			row.createCell(22).setCellValue(s.getPostEndTime());
			row.createCell(23).setCellValue(s.getDuration());
			row.createCell(24).setCellValue(s.getPostRemarks());

		}

		workbook.write(response.getOutputStream());
		workbook.close();
	}

	@GetMapping("/qc")
	public String qc() {
		return "online_qc.html";
	}

	@PostMapping("/qc")
	public String addQc(@ModelAttribute QcSupervisor qc, ModelMap map) {
		qcrepository.save(qc);
		map.put("message", " added succesfully");
		return "redirect:/planning";
	}

	@GetMapping("/export-qcsupervisor-report")
	public void exportQCSupervisorReport(HttpServletResponse response) throws IOException {
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setHeader("Content-Disposition", "attachment; filename=qc_supervisor_report.xlsx");

		List<QcSupervisor> list = qcrepository.findAll();

		Workbook workbook = new XSSFWorkbook();
		org.apache.poi.ss.usermodel.Sheet sheet = workbook.createSheet("QC Supervisor");

		Row header = sheet.createRow(0);
		String[] columns = { "ID", "Component Name", "Route Card No", "Formulation No", "Order Date", "Machine",
				"Method", "Material", "Work Order No", "Material Repeat", "Tool Die No", "Batch No", "Batch Weight",
				"Extruder RPM", "DC Oven Temp", "Weight per Meter", "Production per Hour", "Conveyor RPM",
				"Setup Tool Die No", "No of Cavity", "Method Date", "Start Time", "End Time", "Planned Qty",
				"Processed Qty", "OK Qty", "Not OK Qty", "Operator Name", "Post Received Qty", "Post Processed Qty",
				"Post Temp", "Post Start", "Post End", "Post Duration", "Status" };

		for (int i = 0; i < columns.length; i++) {
			header.createCell(i).setCellValue(columns[i]);
		}

		int rowIdx = 1;
		for (QcSupervisor q : list) {
			Row row = sheet.createRow(rowIdx++);
			row.createCell(0).setCellValue(q.getId());
			row.createCell(1).setCellValue(q.getComponentName());
			row.createCell(2).setCellValue(q.getRouteCardNo());
			row.createCell(3).setCellValue(q.getFormulationNo());
			row.createCell(4).setCellValue(q.getOrderDate());
			row.createCell(5).setCellValue(q.getMachine());
			row.createCell(6).setCellValue(q.getMethod());
			row.createCell(7).setCellValue(q.getMaterial());
			row.createCell(8).setCellValue(q.getWorkOrderNo());

			row.createCell(10).setCellValue(q.getToolDieNo());

			row.createCell(11).setCellValue(q.getBatchNo());
			row.createCell(12).setCellValue(q.getBatchWeight());
			row.createCell(13).setCellValue(q.getExtruderRPM());
			row.createCell(14).setCellValue(q.getDcOvenTemp());
			row.createCell(15).setCellValue(q.getWeightPerMeter());
			row.createCell(16).setCellValue(q.getProductionPerHour());
			row.createCell(17).setCellValue(q.getConveyorRPM());
			row.createCell(18).setCellValue(q.getSetupToolDieNo());
			row.createCell(19).setCellValue(q.getNoOfCavity());

			row.createCell(20).setCellValue(q.getDate());
			row.createCell(21).setCellValue(q.getMethodStartTime());
			row.createCell(22).setCellValue(q.getMethodEndTime());
			row.createCell(23).setCellValue(q.getPlannedQty());
			row.createCell(24).setCellValue(q.getProcessedQty());
			row.createCell(25).setCellValue(q.getOkQty());
			row.createCell(26).setCellValue(q.getNotOkQty());
			row.createCell(27).setCellValue(q.getOperatorName());

			row.createCell(28).setCellValue(q.getPostReceivedQty());
			row.createCell(29).setCellValue(q.getPostProcessedQty());
			row.createCell(30).setCellValue(q.getPostTemperature());
			row.createCell(31).setCellValue(q.getPostStartTime());
			row.createCell(32).setCellValue(q.getPostEndTime());
			row.createCell(33).setCellValue(q.getPostDuration());

			row.createCell(34).setCellValue(q.getStatus());
		}

		workbook.write(response.getOutputStream());
		workbook.close();
	}

	@GetMapping("/planning")
	public String planning() {
		return "planning.html";
	}

	@PostMapping("/planning")
	public String addPlan(@ModelAttribute Planning plan, ModelMap map) {
		planrepository.save(plan);
		map.put("message", " added succesfully");
		return "redirect:/packing";
	}

	@GetMapping("/export-planning-report")
	public void exportPlanningReport(HttpServletResponse response) throws IOException {
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setHeader("Content-Disposition", "attachment; filename=planning_report.xlsx");

		List<Planning> list = planrepository.findAll();

		Workbook workbook = new XSSFWorkbook();
		org.apache.poi.ss.usermodel.Sheet sheet = workbook.createSheet("Planning");

		Row header = sheet.createRow(0);
		String[] columns = { "ID", "Planned Qty", "Route Card No", "Processed Qty", "Size", "OK Qty", "Not OK Qty",
				"Processed By", "Remarks" };

		for (int i = 0; i < columns.length; i++) {
			header.createCell(i).setCellValue(columns[i]);
		}

		int rowIdx = 1;
		for (Planning p : list) {
			Row row = sheet.createRow(rowIdx++);
			row.createCell(0).setCellValue(p.getId());
			row.createCell(1).setCellValue(p.getPlannedQty());
			row.createCell(2).setCellValue(p.getRouteCardNo());
			row.createCell(3).setCellValue(p.getProcessedQty());
			row.createCell(4).setCellValue(p.getSize());
			row.createCell(5).setCellValue(p.getOkQty());
			row.createCell(6).setCellValue(p.getNotOkQty());
			row.createCell(7).setCellValue(p.getProcessedBy());
			row.createCell(8).setCellValue(p.getRemarks());

		}

		workbook.write(response.getOutputStream());
		workbook.close();
	}

	@GetMapping("/inspection")
	public String inspection() {
		return "inspection.html";
	}

	@PostMapping("/inspection")
	public String addInspec(@ModelAttribute Inspection ins, ModelMap map) {
		insrepository.save(ins);
		map.put("message", "inspection added succesfully");
		return "redirect:/qc";
	}

	@GetMapping("/packing")
	public String packing() {
		return "packing.html";
	}

	@PostMapping("/packing")
	public String addPack(@ModelAttribute Packing pack, ModelMap map) {
		packrepository.save(pack);
		map.put("message", "packing added succesfully");
		return "redirect:/dispatch";
	}

	@GetMapping("/dispatch")
	public String dispatch() {
		return "dispatch.html";
	}

	@PostMapping("/dispatch")
	public String addDis(@ModelAttribute Dispatch dis, ModelMap map) {
		disrepository.save(dis);
		map.put("message", "dispatch done succesfully");
		return "redirect:/dashboard";
	}
//	
//	@PostMapping("/searchOrders")
//	public String searchOrders(@ModelAttribute("search") Search searchDTO, ModelMap model) {
//	    List<Order> results = orepository.searchOrders(searchDTO);
//	    model.put("orders", results); // You can now show this on your result page
//	    return "order-results.html"; // Thymeleaf/HTML page to show results
//	}

	@PostMapping("/searchOrders")
	public String searchOrders(@ModelAttribute("search") Search searchDTO, ModelMap model) {
		cleanEmptyStrings(searchDTO); // 🔁 CLEAN STRINGS

		List<Order> results = orepository.searchOrders(searchDTO);
		model.put("orders", results);
		return "order-results.html";
	}

	// Helper method to convert "" to null
	private void cleanEmptyStrings(Search dto) {
		if (isBlank(dto.getRouteCardNo()))
			dto.setRouteCardNo(null);
		if (isBlank(dto.getCustomerNo()))
			dto.setCustomerNo(null);
		if (isBlank(dto.getCustomerName()))
			dto.setCustomerName(null);
		if (isBlank(dto.getComponentName()))
			dto.setComponentName(null);
		if (isBlank(dto.getEnquiryNo()))
			dto.setEnquiryNo(null);
		if (isBlank(dto.getQuotationNo()))
			dto.setQuotationNo(null);
		if (isBlank(dto.getPurchaseOrder()))
			dto.setPurchaseOrder(null);
		if (isBlank(dto.getFormulationNo()))
			dto.setFormulationNo(null);
		if (isBlank(dto.getWorkOrderNo()))
			dto.setWorkOrderNo(null);
		if (isBlank(dto.getToolDieNo()))
			dto.setToolDieNo(null);
		if (isBlank(dto.getResponsiblePerson()))
			dto.setResponsiblePerson(null);
		if (isBlank(dto.getToolMaker()))
			dto.setToolMaker(null);
	}

	// Helper method to check blank strings
	private boolean isBlank(String s) {
		return s == null || s.trim().isEmpty();
	}

	@GetMapping("/finalinspection")
	public String showForm(ModelMap model) {
		FinalInspectionHeader header = new FinalInspectionHeader();

		// ✅ Add 15 empty rows with row numbers
		List<FinalInspectionRow> rows = new ArrayList<>();
		for (int i = 0; i < 15; i++) {
			FinalInspectionRow row = new FinalInspectionRow();
			row.setRowNo(i + 1); // Important!
			rows.add(row);
		}
		header.setInspectionRows(rows);

		model.put("finalInspectionHeader", header);
		return "finalinspection.html"; // Thymeleaf template name
	}

	// ✅ Save form
	@PostMapping("/saveFinalInspection")
	public String saveForm(@ModelAttribute FinalInspectionHeader finalInspectionHeader) {
		FinalInspectionHeader savedHeader = headerRepo.save(finalInspectionHeader);

		// ✅ Set header and rowNo for each row before saving
		for (int i = 0; i < finalInspectionHeader.getInspectionRows().size(); i++) {
			FinalInspectionRow row = finalInspectionHeader.getInspectionRows().get(i);

			row.setRowNo(i + 1); // Set row number again to be sure
			row.setHeader(savedHeader); // Link each row to the saved header
			rowRepo.save(row);
		}

		return "redirect:/finalinspection";
	}

	@GetMapping("/dispatch-note")
	public String showDispatchForm(ModelMap model) {
		model.put("dispatchApprovalNote", new DispatchApprovalNote());
		return "dispatchnew.html";
	}

	@PostMapping("/dispatch-note")
	public String saveDispatchForm(@ModelAttribute DispatchApprovalNote dispatchApprovalNote, ModelMap model) {
		dispatchRepo.save(dispatchApprovalNote);
		model.put("message", "Dispatch Approval Note saved successfully!");
		return "dispatchnew.html";
	}
	
	@GetMapping("/super-home")
	public String superHome(ModelMap map) {
		
		return "superAdmin-home.html";
	}
}
