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

'Click on \'Export\' button in \'Universal Template EU\' template'
WebUI.click(findTestObject('User Defined Import Export/btn_Actions Buttons', [('templateName') : templateName, ('buttonName') : 'Export']))

'Validate the saved template name'
WebUI.verifyElementAttributeValue(findTestObject('User Defined Import Export/input_Template Name'), 'value', templateName, 
    10)

'Select \'All Products\' workbook'
WebUI.selectOptionByLabel(findTestObject('User Defined Import Export/select_Workbook Name'), workbookName, false)

'Select Taxonomy Version'
WebUI.setText(findTestObject('User Defined Import Export/input_Taxonomy Version'), taxonomyVersion)

'Click on Export Data button'
WebUI.click(findTestObject('User Defined Import Export/btn_Export Data'))

'Wait for Download icon to appear'
WebUI.waitForElementPresent(findTestObject('User Defined Import Export/icn_Download File'), GlobalVariable.G_ShortTimeout)

'Validate the text \'Exported successfully\''
WebUI.verifyElementText(findTestObject('User Defined Import Export/txt_Export_Message'), exportedMsg)

