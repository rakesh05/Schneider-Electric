import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import internal.GlobalVariable as GlobalVariable

import com.kms.katalon.core.annotation.SetUp
import com.kms.katalon.core.annotation.SetupTestCase
import com.kms.katalon.core.annotation.TearDown
import com.kms.katalon.core.annotation.TearDownTestCase

/**
 * Some methods below are samples for using SetUp/TearDown in a test suite.
 */

/**
 * Setup test suite environment.
 */
@SetUp(skipped = false) // Please change skipped to be false to activate this method.
def setUp() {
	'Input username'
	WebUI.setText(findTestObject('Login/input_Username'), GlobalVariable.G_Username)
	
	'Input password'
	WebUI.setText(findTestObject('Login/input_Password'), GlobalVariable.G_Password)
	
	'Click on login button'
	WebUI.click(findTestObject('Login/btn_Login'))	
}

/**
 * Clean test suites environment.
 */
@TearDown(skipped = false) // Please change skipped to be false to activate this method.
def tearDown() {
	'Click on user option'
	WebUI.click(findTestObject('Navigation Menu/icn_User Icon'))

	'Wait for 10 sec'
	WebUI.delay(GlobalVariable.G_Timeout)

	'Click on logout link'
	WebUI.click(findTestObject('Navigation Menu/link_Logout'))
}

/**
 * Run before each test case starts.
 */
@SetupTestCase(skipped = false) // Please change skipped to be false to activate this method.
def setupTestCase() {
	'Mouse over on PIM Module'
	WebUI.mouseOver(findTestObject('Navigation Menu/link_PIM Navigation', [('menu') : 'PIM']))

	'Mouse over on Data Utilities option'
	WebUI.mouseOver(findTestObject('Navigation Menu/link_PIM Navigation', [('menu') : 'Data Utilities']))

	'Click on User Defined Import/Export option'
	WebUI.click(findTestObject('Navigation Menu/link_PIM Navigation', [('menu') : 'User Defined Import/Export']))

	'Verify that User Defined Import/Export page is displayed'
	WebUI.verifyElementText(findTestObject('User Defined Import Export/txt_Section Header'), 'User Defined Import/Export')
}

/**
 * Run after each test case ends.
 */
@TearDownTestCase(skipped = true) // Please change skipped to be false to activate this method.
def tearDownTestCase() {
	// Put your code here.
}

/**
 * References:
 * Groovy tutorial page: http://docs.groovy-lang.org/next/html/documentation/
 */