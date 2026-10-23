package activities.contacts;

import control.Button;
import control.TextBox;
import org.openqa.selenium.By;

public class ContactEditorActivity {

    // La app muestra a veces un solo campo "Name" y a veces "First name"/"Last name";
    // en ambos casos el primer EditText del formulario es el del nombre
    public TextBox nameTextBox = new TextBox(By.xpath("(//android.widget.EditText)[1]"));
    public Button saveButton = new Button(By.xpath("//android.widget.TextView[@text='Save']"));
}
