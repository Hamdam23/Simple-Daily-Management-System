package net.guides.springboot.todomanagement.controller;

import net.guides.springboot.todomanagement.model.Category;
import net.guides.springboot.todomanagement.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class CategoryController {

    private final ICategoryService categoryService;

    public CategoryController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // Date - dd/MM/yyyy
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    @RequestMapping(value = "/list-categories", method = RequestMethod.GET)
    public String showCategories(ModelMap model) {
        String name = getLoggedInUserName(model);
        model.put("categories", categoryService.getCategoriesByUser(name));
        return "list-categories";
    }

    private String getLoggedInUserName(ModelMap model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        }

        return principal.toString();
    }

    @RequestMapping(value = "/add-category", method = RequestMethod.GET)
    public String showAddCategoryPage(ModelMap model) {
        model.addAttribute("category", new Category());
        return "category";
    }

    @RequestMapping(value = "/delete-category", method = RequestMethod.GET)
    public String deleteCategory(@RequestParam long id) {
        categoryService.deleteCategory(id);
        return "redirect:/list-categories";
    }

    @RequestMapping(value = "/update-category", method = RequestMethod.GET)
    public String showUpdateCategoryPage(@RequestParam long id, ModelMap model) {
        Category category = categoryService.getCategoryById(id).get();
        model.put("category", category);
        return "category";
    }

    @RequestMapping(value = "/update-category", method = RequestMethod.POST)
    public String updateCategory(ModelMap model, @Valid Category category, BindingResult result) {

        if (result.hasErrors()) {
            return "category";
        }

        category.setUserName(getLoggedInUserName(model));
        categoryService.updateCategory(category);
        return "redirect:/list-categories";
    }

    @RequestMapping(value = "/add-category", method = RequestMethod.POST)
    public String addCategory(ModelMap model, @Valid Category category, BindingResult result) {

        if (result.hasErrors()) {
            return "category";
        }

        category.setUserName(getLoggedInUserName(model));
        categoryService.saveCategory(category);
        return "redirect:/list-categories";
    }
}
