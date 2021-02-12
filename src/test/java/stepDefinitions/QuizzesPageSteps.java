package stepDefinitions;

import org.junit.Assert;
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
		quizPage.clickOnMCTypeQuestion();
	}

	@Then("Teacher views the MC Type with all the default options")
	public void teacher_views_the_mc_type_with_all_the_default_options() {
		softAssert.assertTrue(quizPage.verifyQuestionView("Multiple Choice"));
	}
	
	@When("Teacher enters Multiple Choice Question")
	public void teacher_enters_multiple_choice_question() {
		quizPage.enterMCTypeQuestion();
	}

	@When("Teacher enters the Options\\/Answers for the question")
	public void teacher_enters_the_options_answers_for_the_question() {
		quizPage.enterAnswersForQuestion();
	}

	@When("Teacher chooses right answer for MC Question")
	public void teacher_chooses_right_answer_for_mc_question() {
		quizPage.selectCorrectMCAnswer();
	}

	@When("Teacher clicks on Save Question button")
	public void teacher_clicks_on_save_question_button()
	{
		quizPage.clickOnSaveQuestion();
	}
	
	@Then("Teacher views the Multiple Choice Question is Saved into Quiz")
	public void teacher_views_the_multiple_choice_question_is_saved_into_quiz() {
		quizPage.validateQuestionView();
	}

	@Then("Teacher views {string} text with Question Types")
	public void teacher_views_add_a_question_text_with_question_types(String text) {
		quizPage.validateQuestionTextAndTypes(text);
	}

	@When("Teacher clicks on True\\/False Question")
	public void teacher_clicks_on_true_false_question() {
		quizPage.clickOnTrueFalseQuestion();
	}

	@Then("Teacher views the TF Type with all the default options")
	public void teacher_views_the_tf_type_with_all_the_default_options() {
		Assert.assertTrue(quizPage.verifyQuestionView("True False"));
	}

	@When("Teachers enters the True\\/False Question")
	public void teachers_enters_the_true_false_question() {
		quizPage.enterTFTypeQuestion();
	}

	@When("Teacher selects the correct option")
	public void teacher_selects_the_correct_option() {
		quizPage.selectCorrectTFAnswer();
	}

	@When("Teacher enters the Explanation for the TF Question")
	public void teacher_enters_explanation_for_the_tf_question() {
		quizPage.enterExplanationForTFQ();
	}

	@Then("Teacher views the True\\/False Question is Added into Quiz")
	public void teacher_views_the_true_false_question_is_added_into_quiz() {
		quizPage.validateQuestionView();
	}

	@When("Teacher clicks on Short Answer Question")
	public void teacher_clicks_on_short_answer_question() {
		quizPage.clickOnShortAnswerQuestion();
	}

	@Then("Teacher views the SA Type with all the default options")
	public void teacher_views_the_sa_type_with_all_the_default_options() {
		Assert.assertTrue(quizPage.verifyQuestionView("Short Answer"));
	}

	@When("Teacher enters the Short Answer Question")
	public void teacher_enters_the_short_answer_question() {
		quizPage.enterSATypeQuestion();
	}

	@When("Teacher enters the correct answers for SA Question")
	public void teacher_enters_the_correct_answers_for_sa_question() {
		quizPage.selectCorrectSAAnswer();
	}

	@Then("Teacher views the SA Question is saved into Quiz")
	public void teacher_views_the_sa_question_is_saved_into_quiz() {
		quizPage.validateQuestionView();
	}

	@When("Teacher clicks on Save and Exit Button to Save the Quiz")
	public void teacher_clicks_on_save_and_exit_button_to_save_the_quiz() {
		quizPage.clickOnSaveAndExit();
	}

	@Then("Teacher views the Quiz is saved in the top of the Quiz List in Quizzes Tab")
	public void teacher_views_the_quiz_is_saved_in_the_top_of_the_quiz_list_in_quizzes_tab() {
		Assert.assertTrue(quizPage.verifyQuizNameFromList());
	}

}
