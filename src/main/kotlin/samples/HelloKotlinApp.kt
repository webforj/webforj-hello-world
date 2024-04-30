import com.webforj.App
import com.webforj.annotation.InlineStyleSheet
import com.webforj.component.button.Button
import com.webforj.component.button.ButtonTheme
import com.webforj.component.field.TextField
import com.webforj.component.html.elements.Div
import com.webforj.component.layout.flexlayout.FlexLayout
import com.webforj.component.window.Frame

/**
 * @author Christian Liebhardt
 */
@InlineStyleSheet("context://css/buttonstyles/demo_styles.css")
class HelloKotlinApp: App() {
    val root: Div
    val clear = Button("Clear")
        .setTheme(ButtonTheme.DEFAULT)
    val submit = Button("Submit")
        .setTheme(ButtonTheme.PRIMARY)
    val firstName = TextField(TextField.Type.TEXT, "First Name", "Jason")
    val lastName = TextField(TextField.Type.TEXT, "Last Name", "Turner")
    val email = TextField(TextField.Type.EMAIL, "E-mail:", "turner.jason@email.com")
    val firstRow = FlexLayout.create(firstName, lastName)
        .justify().center()
        .wrap()
        .build()
        .setSpacing("20px")
        .addClassName("row")
    val secondRow = FlexLayout.create(email)
        .justify().center()
        .wrap()
        .build()
        .setSpacing("20px")
        .addClassName("row")
    val thirdRow = FlexLayout.create(submit, clear)
        .justify().center()
        .wrap()
        .build()
        .setSpacing("20px")
        .addClassName("row")

    init {
        root = Div()
        root.addClassName("window")
        root.add(firstRow, secondRow, thirdRow)
        submit.onClick {
            msgbox("Welcome to the application ${firstName.text} ${lastName.text}!")
        }
        clear.onClick {
            firstName.text = ""
            lastName.text = ""
            email.setText("")
        }
    }

    override fun run() {
        val window = Frame()
        window.add(root)
    }

}