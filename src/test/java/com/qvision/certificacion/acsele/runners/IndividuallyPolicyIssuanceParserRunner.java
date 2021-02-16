package com.qvision.certificacion.acsele.runners;

import org.junit.runner.RunWith;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/PolicyIssuanceParser.feature", glue = "com.qvision.certificacion.acsele.stepsdefinitions", snippets = SnippetType.CAMELCASE, tags = "@IndividuallyFrom")
public class IndividuallyPolicyIssuanceParserRunner {

}
