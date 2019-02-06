import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

'Mouse over on PIM Module'
WebUI.mouseOver(findTestObject('Navigation Menu/link_PIM Navigation', [('menu') : 'PIM']))

'Mouse over on Product Master option'
WebUI.mouseOver(findTestObject('Navigation Menu/link_PIM Navigation', [('menu') : 'Product Master']))

'Click on Item option'
WebUI.click(findTestObject('Navigation Menu/link_PIM Navigation', [('menu') : 'Items']))

'Click on Add New Item icon'
WebUI.click(findTestObject('Top Nav Right Icons/icn_Add Icon'))

'Wait for 10 sec'
WebUI.delay(GlobalVariable.G_Timeout)

'Select the brand name'
WebUI.selectOptionByLabel(findTestObject('Items/General Info/select_Brand Name'), brandName, false)

'Enter the part number'
WebUI.setText(findTestObject('Items/General Info/input_Part Number'), partNumber)

'Click on Save Icon'
WebUI.click(findTestObject('Items/icn_Save Icon'))

'Wait for 10 sec'
WebUI.delay(GlobalVariable.G_Timeout)

'Read alert message text'
alertMsg = WebUI.getAlertText()

'Compare alert text with the expected text'
WebUI.verifyMatch(alertMsg, 'Updated Successfully', false)

'Click on Ok button on alert'
WebUI.acceptAlert()

@com.kms.katalon.core.annotation.TearDownIfPassed
def clearTestItem() {
    'Enter the part number in search field'
    WebUI.setText(findTestObject('Navigation Menu/input_Search Field'), partNumber)

    'Click on search icon'
    WebUI.click(findTestObject('Navigation Menu/icn_Search Icon'))

    'Wait for item to appear'
    WebUI.waitForElementPresent(findTestObject('Items/Item List/icn_Delete Icon', [('partNumber') : partNumber]), GlobalVariable.G_Timeout)

    'Click on delete icon'
    WebUI.click(findTestObject('Items/Item List/icn_Delete Icon', [('partNumber') : partNumber]))

    'Wait for 10 sec'
    WebUI.delay(GlobalVariable.G_Timeout)

    'Click Yes button on delete item popup'
    WebUI.click(findTestObject('Items/Item List/btn_Yes Button'))
}

