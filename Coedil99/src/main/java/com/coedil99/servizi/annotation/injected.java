package com.coedil99.servizi.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)

@Documented
public @interface injected {
	public String serviceImplementation();
}
