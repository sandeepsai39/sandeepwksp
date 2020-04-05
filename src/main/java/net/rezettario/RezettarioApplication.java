package net.rezettario;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import javax.ws.rs.core.Application;

@OpenAPIDefinition(
        tags = {
                @Tag(name="Food", description="operations related to food api"),
                @Tag(name="User", description="Operations related to user api"),
                @Tag(name="Tags", description="Operations related to tags api")
        },
        info = @Info(
                title="Rezettario API",
                version = "1.0.0",
                contact = @Contact(
                        name = "Rezettario API Support",
                        url = "http://Rezettariorl.com/contact",
                        email = "Rezettario@example.com"),
                license = @License(
                        name = "Apache 2.0",
                        url = "http://www.apache.org/licenses/LICENSE-2.0.html"))
)
public class RezettarioApplication extends Application {
}
