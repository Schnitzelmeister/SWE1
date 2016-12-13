package reporting;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
public @interface ReportDescription {
	String Description();
}
