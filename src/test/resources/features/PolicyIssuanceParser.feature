@PolicyIssuanceparser
Feature: BulkPolicyIssuance(parser)
 	as an alfa insurance operator, I would like to issue policies both individually (From) and in bulk.

  @IndividuallyFrom
  Scenario: Acsel-E issue policies Individually(From).
    Given As a collaborator of alfa insurance, I would like to issue policies.
    When Login into the application and create policies.
    Then The policies Individually was successfully created.

  @Bulkmassive
  Scenario: Acsel-E issue policies Bulk(massive).
    Given As a partner of Alpha insurance, I would like to issue policies massively.
    When Issue policies in bulk after logging into the app.		
    Then The policies massively was successfully created.

