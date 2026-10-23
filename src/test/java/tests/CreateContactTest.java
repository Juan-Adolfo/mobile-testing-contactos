package tests;
import activities.contacts.ContactDetailActivity;
import activities.contacts.ContactEditorActivity;
import activities.contacts.ContactListActivity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sesion.Sesion;
public class CreateContactTest {

    ContactListActivity contactListActivity = new ContactListActivity();
    ContactEditorActivity contactEditorActivity = new ContactEditorActivity();
    ContactDetailActivity contactDetailActivity = new ContactDetailActivity();

    @AfterEach
    public void tearDown(){
        Sesion.getSesion().closeSesion();
    }

    @Test
    public void createContact(){
        String name = "UCB Test" + System.currentTimeMillis();
        contactListActivity.createContactButton.click();
        contactEditorActivity.nameTextBox.setText(name);
        contactEditorActivity.saveButton.click();
        Assertions.assertTrue(contactDetailActivity.editContactButton.isControlDisplayed());
        Assertions.assertEquals(name, contactDetailActivity.nameLabel(name).getText());
    }
}
