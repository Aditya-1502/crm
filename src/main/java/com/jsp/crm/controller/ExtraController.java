package com.jsp.crm.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jsp.crm.model.Coating;
import com.jsp.crm.model.Dispatch;
import com.jsp.crm.model.DispatchApprovalNote;
import com.jsp.crm.model.Extrusion;
import com.jsp.crm.model.Inspection;
import com.jsp.crm.model.Jointing;
import com.jsp.crm.model.Mixing;
import com.jsp.crm.model.Moulding;
import com.jsp.crm.model.Order;
import com.jsp.crm.model.Packing;
import com.jsp.crm.model.Planning;
import com.jsp.crm.model.Production;
import com.jsp.crm.model.QcSupervisor;
import com.jsp.crm.model.Sheeting;
import com.jsp.crm.repository.CoatingRepository;
import com.jsp.crm.repository.DispatchApprovalNoteRepository;
import com.jsp.crm.repository.DispatchRepository;
import com.jsp.crm.repository.ExtrusionRepository;
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

import ch.qos.logback.core.model.Model;

@Controller
public class ExtraController {

	@Autowired
	ProdRepository prodRepository;

	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	ExtrusionRepository extRepository;
	
	@Autowired
	MixRepository mixingRepository;
	
	@Autowired
	CoatingRepository coatRepository;
	
	@Autowired
	JointingRepository jointRepository;
	
	@Autowired
	MouldRepository mouldRepository;
	
	@Autowired
	SheetingRepository sheetRepository;
	
	@Autowired
	QcRepository qcRepository;
	
	@Autowired
	PlanningRepository planRepository;
	
	@Autowired
	InspectionRepository inspectRepository;
	
	@Autowired
	PackingRepository packRepository;
	
	@Autowired
	DispatchRepository dispatchRepository;
	
	@Autowired
	DispatchApprovalNoteRepository danRepository;
	
	@GetMapping("/fetch-by-route-mixing")
	public String fetchByRouteMixing(@RequestParam String routeCardNo, ModelMap map) {
		Order order = orderRepository.findByRouteCardNo(routeCardNo);
	    Production production = prodRepository.findByRouteCardNo(routeCardNo);
	    
	    if (order != null) {
	    	 map.put("order", order);
	    } else {
	       map.put("order", new Order()); // Send empty object to avoid Thymeleaf error
	        map.put("message", "Route Card not found");
	    }

	    if (production != null) {
	        map.put("production", production);
	    } else {
	        map.put("production", new Production());
	        map.put("message", "Route Card not found in Production");
	    }
	    
		    
		return "mixing.html";
	}
	
	@GetMapping("/fetch-by-route-extrusion")
	public String fetchByRouteExtrusion(@RequestParam String routeCardNo, ModelMap map) {
	    Order order = orderRepository.findByRouteCardNo(routeCardNo);
	    Production production = prodRepository.findByRouteCardNo(routeCardNo);
	    
	    if (order != null) {
	    	 map.put("order", order);
	    } else {
	       map.put("order", new Order()); // Send empty object to avoid Thymeleaf error
	        map.put("message", "Route Card not found");
	    }

	    if (production != null) {
	        map.put("production", production);
	    } else {
	        map.put("production", new Production());
	        map.put("message", "Route Card not found in Production");
	    }
	    
	    return "extrusion.html"; // View name
	}
	    

	@GetMapping("/fetch-by-route-moulding")
	public String fetchByRouteMoulding(@RequestParam String routeCardNo, ModelMap map) {
	    Order order = orderRepository.findByRouteCardNo(routeCardNo);
	    Production production = prodRepository.findByRouteCardNo(routeCardNo);
	    Extrusion extrusion = extRepository.findByRouteCardNo(routeCardNo);
	    if (order != null) {
	    	 map.put("order", order);
	    } else {
	       map.put("order", new Order()); // Send empty object to avoid Thymeleaf error
	        map.put("message", "Route Card not found");
	    }

	    if (production != null) {
	        map.put("production", production);
	    } else {
	        map.put("production", new Production());
	        map.put("message", "Route Card not found in Production");
	    }
	    
	    if (extrusion != null) {
	        map.put("extrusion", extrusion);
	    } else {
	        map.put("extrusion", new Extrusion());
	        map.put("prodError", "Route Card not found in Production");
	    }
	    return "moulding.html"; // View name
	}
	    
	@GetMapping("/fetch-by-route-jointing")
	public String fetchByRouteJointing(@RequestParam String routeCardNo, ModelMap map) {
	    Order order = orderRepository.findByRouteCardNo(routeCardNo);
	    Production production = prodRepository.findByRouteCardNo(routeCardNo);
	    Extrusion extrusion = extRepository.findByRouteCardNo(routeCardNo);
	    if (order != null) {
	    	 map.put("order", order);
	    } else {
	       map.put("order", new Order()); // Send empty object to avoid Thymeleaf error
	        map.put("message", "Route Card not found");
	    }

	    if (production != null) {
	        map.put("production", production);
	    } else {
	        map.put("production", new Production());
	        map.put("prodError", "Route Card not found in Production");
	    }
	    
	    if (extrusion != null) {
	        map.put("extrusion", extrusion);
	    } else {
	        map.put("extrusion", new Extrusion());
	        map.put("prodError", "Route Card not found in Production");
	    }
	    return "jointing.html"; // View name
	}    
	    
	@GetMapping("/fetch-by-route-sheeting")
	public String fetchByRouteSheeting(@RequestParam String routeCardNo, ModelMap map) {
	    Order order = orderRepository.findByRouteCardNo(routeCardNo);
	    Production production = prodRepository.findByRouteCardNo(routeCardNo);
	    Extrusion extrusion = extRepository.findByRouteCardNo(routeCardNo);
	    if (order != null) {
	    	 map.put("order", order);
	    } else {
	       map.put("order", new Order()); // Send empty object to avoid Thymeleaf error
	        map.put("message", "Route Card not found");
	    }

	    if (production != null) {
	        map.put("production", production);
	    } else {
	        map.put("production", new Production());
	        map.put("prodError", "Route Card not found in Production");
	    }
	    
	    if (extrusion != null) {
	        map.put("extrusion", extrusion);
	    } else {
	        map.put("extrusion", new Extrusion());
	        map.put("prodError", "Route Card not found in Production");
	    }
	    return "sheeting.html"; // View name
	}     
	
	@GetMapping("/fetch-by-route-coating")
	public String fetchByRouteCoating(@RequestParam String routeCardNo, ModelMap map) {
	    Order order = orderRepository.findByRouteCardNo(routeCardNo);
	    Production production = prodRepository.findByRouteCardNo(routeCardNo);
	    Extrusion extrusion = extRepository.findByRouteCardNo(routeCardNo);
	    if (order != null) {
	    	 map.put("order", order);
	    } else {
	       map.put("order", new Order()); // Send empty object to avoid Thymeleaf error
	        map.put("message", "Route Card not found");
	    }

	    if (production != null) {
	        map.put("production", production);
	    } else {
	        map.put("production", new Production());
	        map.put("prodError", "Route Card not found in Production");
	    }
	    
	    if (extrusion != null) {
	        map.put("extrusion", extrusion);
	    } else {
	        map.put("extrusion", new Extrusion());
	        map.put("prodError", "Route Card not found in Production");
	    }
	    return "coating.html"; // View name
	}     
	   
	@GetMapping("/fetch-by-route-qc")
	public String fetchByRouteQc(@RequestParam String routeCardNo, ModelMap map) {
	    Order order = orderRepository.findByRouteCardNo(routeCardNo);
	    Production production = prodRepository.findByRouteCardNo(routeCardNo);
	    Extrusion extrusion = extRepository.findByRouteCardNo(routeCardNo);
	    if (order != null) {
	    	 map.put("order", order);
	    } else {
	       map.put("order", new Order()); // Send empty object to avoid Thymeleaf error
	        map.put("message", "Route Card not found");
	    }

	    if (production != null) {
	        map.put("production", production);
	    } else {
	        map.put("production", new Production());
	        map.put("prodError", "Route Card not found in Production");
	    }
	    
	    if (extrusion != null) {
	        map.put("extrusion", extrusion);
	    } else {
	        map.put("extrusion", new Extrusion());
	        map.put("prodError", "Route Card not found in Production");
	    }
	    return "online_qc.html"; // View name
	}     
	 
	@GetMapping("/fetch-by-route-production")
	public String fetchByRouteProd(@RequestParam String routeCardNo, ModelMap map) {
	    Order order = orderRepository.findByRouteCardNo(routeCardNo);
	    Production production = prodRepository.findByRouteCardNo(routeCardNo);
	    Extrusion extrusion = extRepository.findByRouteCardNo(routeCardNo);
	    Mixing mixing = mixingRepository.findByRouteCardNo(routeCardNo);
	    
	    if (order != null) {
	    	 map.put("order", order);
	    } else {
	       map.put("order", new Order()); // Send empty object to avoid Thymeleaf error
	        map.put("message", "Route Card not found");
	    }

	    if (production != null) {
	        map.put("production", production);
	    } else {
	        map.put("production", new Production());
	        map.put("prodError", "Route Card not found in Production");
	    }
	    
	    if (extrusion != null) {
	        map.put("extrusion", extrusion);
	    } else {
	        map.put("extrusion", new Extrusion());
	        map.put("prodError", "Route Card not found in Production");
	    }
	    
	    if (mixing != null) {
	        map.put("mixing", mixing);
	    } else {
	        map.put("mixing", new Mixing());
	        map.put("prodError", "Route Card not found in Production");
	    }
	    return "production.html"; // View name
	}  
	
	
	@GetMapping("/fetch-by-route-search")
	public String fetchByRouteSearch(@RequestParam String routeCardNo, ModelMap map) {
	    Order order = orderRepository.findByRouteCardNo(routeCardNo);
	    Production production = prodRepository.findByRouteCardNo(routeCardNo);
	    Extrusion extrusion = extRepository.findByRouteCardNo(routeCardNo);
	    Mixing mixing = mixingRepository.findByRouteCardNo(routeCardNo);
	    Coating coating = coatRepository.findByRouteCardNo(routeCardNo);
	    Jointing jointing = jointRepository.findByRouteCardNo(routeCardNo);
	    Moulding moulding = mouldRepository.findByRouteCardNo(routeCardNo);
	    Sheeting sheeting = sheetRepository.findByRouteCardNo(routeCardNo);
	    QcSupervisor qc = qcRepository.findByRouteCardNo(routeCardNo);
	    Planning planning = planRepository.findByRouteCardNo(routeCardNo);
	    Inspection inspection = inspectRepository.findByRouteCardNo(routeCardNo);
	    Packing packing = packRepository.findByRouteCardNo(routeCardNo);
	    Dispatch dispatch = dispatchRepository.findByRouteCardNo(routeCardNo);
	    DispatchApprovalNote dan = danRepository.findByRouteCardNo(routeCardNo);

	    if (order != null) {
	        map.put("order", order);
	    } else {
	        map.put("order", new Order());
	        map.put("orderError", "Route Card not found in Order");
	    }

	    if (production != null) {
	        map.put("production", production);
	    } else {
	        map.put("production", new Production());
	        map.put("productionError", "Route Card not found in Production");
	    }

	    if (extrusion != null) {
	        map.put("extrusion", extrusion);
	    } else {
	        map.put("extrusion", new Extrusion());
	        map.put("extrusionError", "Route Card not found in Extrusion");
	    }

	    if (mixing != null) {
	        map.put("mixing", mixing);
	    } else {
	        map.put("mixing", new Mixing());
	        map.put("mixingError", "Route Card not found in Mixing");
	    }

	    if (coating != null) {
	        map.put("coating", coating);
	    } else {
	        map.put("coating", new Coating());
	        map.put("coatingError", "Route Card not found in Coating");
	    }

	    if (jointing != null) {
	        map.put("jointing", jointing);
	    } else {
	        map.put("jointing", new Jointing());
	        map.put("jointingError", "Route Card not found in Jointing");
	    }

	    if (moulding != null) {
	        map.put("moulding", moulding);
	    } else {
	        map.put("moulding", new Moulding());
	        map.put("mouldingError", "Route Card not found in Moulding");
	    }

	    if (sheeting != null) {
	        map.put("sheeting", sheeting);
	    } else {
	        map.put("sheeting", new Sheeting());
	        map.put("sheetingError", "Route Card not found in Sheeting");
	    }

	    if (qc != null) {
	        map.put("qc", qc);
	    } else {
	        map.put("qc", new QcSupervisor());
	        map.put("qcError", "Route Card not found in QC Supervisor");
	    }

	    if (planning != null) {
	        map.put("planning", planning);
	    } else {
	        map.put("planning", new Planning());
	        map.put("planningError", "Route Card not found in Planning");
	    }

	    if (inspection != null) {
	        map.put("inspection", inspection);
	    } else {
	        map.put("inspection", new Inspection());
	        map.put("inspectionError", "Route Card not found in Inspection");
	    }

	    if (packing != null) {
	        map.put("packing", packing);
	    } else {
	        map.put("packing", new Packing());
	        map.put("packingError", "Route Card not found in Packing");
	    }

	    if (dispatch != null) {
	        map.put("dispatch", dispatch);
	    } else {
	        map.put("dispatch", new Dispatch());
	        map.put("dispatchError", "Route Card not found in Dispatch");
	    }

	    if (dan != null) {
	        map.put("dan", dan);
	    } else {
	        map.put("dan", new DispatchApprovalNote());
	        map.put("danError", "Route Card not found in Dispatch Approval Note");
	    }

	    return "search.html";
	}
 
	
	   
}