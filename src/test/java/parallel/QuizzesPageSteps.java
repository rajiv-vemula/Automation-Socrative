package parallel;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class QuizzesPageSteps {

	
	@When("Teacher clicks on Quizzes Tab, Add Quiz and Create New")
	public void teacher_clicks_on_quizzes_tab_add_quiz_and_create_new() {
	}

	@Then("Teacher views the default name and question types in the page")
	public void teacher_views_the_default_name_and_question_types_in_the_page() {
	}

	@When("Teacher enters the {string}")
	public void teacher_enters_the(String quizName) {
	    System.out.println("Quiz Name: "+ quizName);
	}


	@When("Teacher clicks on Multiple Choice Question Type")
	public void teacher_clicks_on_multiple_choice_question_type() {
	}

	@Then("Teacher views the MC Type with all the default options")
	public void teacher_views_the_mc_type_with_all_the_default_options() {
	}

}
