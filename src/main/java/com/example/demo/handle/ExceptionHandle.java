package com.example.demo.handle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.domain.Result;
import com.example.demo.exception.PersonException;
import com.example.demo.utils.ResultUtil;

@ControllerAdvice
public class ExceptionHandle {

	private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public Result handle(Exception e) {
		if (e instanceof PersonException) {
			PersonException personException = (PersonException) e;
			return ResultUtil.error(personException.getCode(), personException.getMessage());
		} else {
			logger.error("系统异常:{}", e);
			return ResultUtil.error(-1, "未知错误");
		}
	}
}
