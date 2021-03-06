package com.essam.www.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.essam.www.exception.CommonException;


@ControllerAdvice
public class BAdvice {
	@ExceptionHandler(CommonException.class)
	public String except(CommonException ex, RedirectAttributes attr) {
		attr.addFlashAttribute("fMsg", ex.getMessage());
		return "redirect:/";
	}
}
	