package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import com.Factory.DriverFactory;
import com.pages.QuizzesPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class QuizzesPageSteps {
	
	private QuizzesPage quizPage;
	private WebDriver driver;
	private SoftAssert softAssert;
	
	public QuizzesPageSteps()
	{
		driver = DriverFactory.getDriver();
		quizPage = new QuizzesPage(driver);
		softAssert = new SoftAssert();
	}

	
	@When("Teacher clicks on Quizzes Tab")
	public void teacher_clicks_on_quizzes_tab() {
		quizPage.clickOnQuizzesTab();
	}
	
	@Then("Teacher views the {string} Page")
	public void teacher_views_the_page(String title) {
		softAssert.assertEquals(title, quizPage.verifyPageTitle(title));
	}

	@When("Teacher clicks on Add Quiz and Create New")
	public void teacher_clicks_on_add_quiz_and_create_new() {
		quizPage.clickOnAddQuiz();
		quizPage.clickOnCreateNew();
	}
	
	@Then("Teacher views the default name, toggles and question types in the page")
	public void teacher_views_the_default_name_toggles_and_question_types_in_the_page() {
		softAssert.assertEquals("Untitled Quiz", quizPage.getQuizTitle());
		quizPage.verifyToggles();
		quizPage.verifyQuestionTypes();
	}

	@When("Teacher enters the Quiz Name")
	public void teacher_enters_the_quiz_name() {
		quizPage.enterQuizName();
	}

	@When("Teacher clicks on Multiple Choice Question Type")
	public void teacher_clicks_on_multiple_choice_question_type() {
		quizPage.enterMCTypeQuestion();
	}

	@Then("Teacher views the MC Type with all the default options")
	public void teacher_views_the_mc_type_with_all_the_default_options() {
		softAssert.assertTrue(quizPage.verifyMCTypeOptions());
	}

}
