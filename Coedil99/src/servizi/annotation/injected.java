package servizi.annotation;

import java.lang.annotation.Documented;

@Documented
public @interface injected {
	String serviceImplementation();
}
