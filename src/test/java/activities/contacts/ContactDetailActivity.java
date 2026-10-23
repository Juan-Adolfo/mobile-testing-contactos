package activities.contacts;

import control.Button;
import control.Label;
import org.openqa.selenium.By;

public class ContactDetailActivity {

    // Solo existe en la pantalla de detalle de un contacto
    public Button editContactButton = new Button(By.id("com.google.android.contacts:id/menu_insert_or_edit"));

    // El titulo con el nombre no siempre tiene resource-id, por eso se busca por su texto
    public Label nameLabel(String name){
        return new Label(By.xpath("//android.widget.TextView[@text='" + name + "']"));
    }
}
