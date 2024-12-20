package com.example.car_management.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.car_management.entity.Car;
import com.example.car_management.service.CarService;

;
@Controller
public class CarController {
    
     @Autowired
        private CarService cservice;
        @GetMapping("/")
        public String viewHomePage(Model model) {
            List<Car> listcar = cservice.listAll();
            model.addAttribute("listcar", listcar);
//            System.out.print("Get / ");    
            return "index";
        }
        @GetMapping("/new")
        public String add(Model model) {
            model.addAttribute("car", new Car());
            return "new.html";
        }
        @RequestMapping(value = "/save", method = RequestMethod.POST)
        public String saveCar(@ModelAttribute("car") Car car) {
            cservice.save(car);
            return "redirect:/";
        }
        @RequestMapping("/edit/{id}")
        public ModelAndView showEditCarPage(@PathVariable(name ="id") int id) {
            ModelAndView mav = new ModelAndView("new");
            Car car = cservice.get(id);
            mav.addObject("car", car);
            return mav;
            
        }
        @GetMapping("/search")
        public String searchCar(@RequestParam("name") String name, Model model) {
             List<Car> carList=cservice.searchByName(name); // Implement searchByName() in your service
            if (!carList.isEmpty()) {
                model.addAttribute("car", carList.get(0)); // Assuming a single result
            } else {
                model.addAttribute("car", null);
            }
            return "searchcar"; // Redirects to the search results page
        }
        @RequestMapping("/delete/{id}")
        public String deletestudent(@PathVariable(name = "id") int id) {
            cservice.delete(id);
            return "redirect:/";
        }
}