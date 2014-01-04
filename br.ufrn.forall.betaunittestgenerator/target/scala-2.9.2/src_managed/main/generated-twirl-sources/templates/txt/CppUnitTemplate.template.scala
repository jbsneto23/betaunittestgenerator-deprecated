
package templates.txt

import twirl.api._
import TemplateMagic._


/**/
object CppUnitTemplate extends BaseScalaTemplate[twirl.api.Txt,Format[twirl.api.Txt]](twirl.api.TxtFormat) with twirl.api.Template2[builders.CppUnitBuilder,models.TestSuite,twirl.api.Txt] {

    /**/
    def apply/*1.2*/(builder: builders.CppUnitBuilder, testSuite: models.TestSuite):twirl.api.Txt = {
        _display_ {

Seq(format.raw/*1.65*/("""
#include <cppunit/extensions/HelperMacros.h>
#include <cppunit/extensions/TestFactoryRegistry.h>
#include <cppunit/TestRunner.h>
"""),_display_(Seq(/*5.2*/defining(testSuite.getMachineName())/*5.38*/{ className =>_display_(Seq(format.raw/*5.52*/("""
/** 
* Machine: """),_display_(Seq(/*7.13*/testSuite/*7.22*/.getMachineName())),format.raw/*7.39*/("""
* Operation: """),_display_(Seq(/*8.15*/testSuite/*8.24*/.getOperationUnderTest())),format.raw/*8.48*/("""
*
* Partition Strategy: """),_display_(Seq(/*10.24*/testSuite/*10.33*/.getPartitionStrategy())),format.raw/*10.56*/("""
* Combination Strategy: """),_display_(Seq(/*11.26*/testSuite/*11.35*/.getCombinatorialCriteria())),format.raw/*11.62*/("""
* Oracle Strategy: """),_display_(Seq(/*12.21*/testSuite/*12.30*/.getOracleStrategy().getStrategy())),format.raw/*12.64*/("""
*/
class """),_display_(Seq(/*14.8*/{builder.className(testSuite)})),format.raw/*14.38*/(""" : public CppUnit::TestFixture
"""),format.raw("""{"""),format.raw/*15.2*/("""
	CPPUNIT_TEST_SUITE( """),_display_(Seq(/*16.23*/{builder.className(testSuite)})),format.raw/*16.53*/(""" );
	"""),_display_(Seq(/*17.3*/for(testCase <- testSuite.getTestCases()) yield /*17.44*/{_display_(Seq(format.raw/*17.45*/("""
	CPPUNIT_TEST( testCase"""),_display_(Seq(/*18.25*/(testCase.getId()))),format.raw/*18.43*/(""" );
	""")))})),format.raw/*19.3*/("""
	CPPUNIT_TEST_SUITE_END();
	
	private:
		"""),_display_(Seq(/*23.4*/(className))),format.raw/*23.15*/(""" *"""),_display_(Seq(/*23.18*/(className.toLowerCase()))),format.raw/*23.43*/(""";
	
	public:
		void setUp()
		"""),format.raw("""{"""),format.raw/*27.4*/("""
			"""),_display_(Seq(/*28.5*/(className.toLowerCase()))),format.raw/*28.30*/(""" = new """),_display_(Seq(/*28.38*/(className))),format.raw/*28.49*/(""";
		"""),format.raw("""}"""),format.raw/*29.4*/("""
		
		void tearDown()
		"""),format.raw("""{"""),format.raw/*32.4*/("""
			delete """),_display_(Seq(/*33.12*/(className.toLowerCase()))),format.raw/*33.37*/(""";
		"""),format.raw("""}"""),format.raw/*34.4*/("""
		"""),_display_(Seq(/*35.4*/if(testSuite.getOracleStrategy() == models.OracleStrategy.STATE_INVARIANT || testSuite.getOracleStrategy() == models.OracleStrategy.STATE_INVARIANT_RETURN_VALUES || testSuite.getOracleStrategy() == models.OracleStrategy.STATE_INVARIANT_VARIABLES || testSuite.getOracleStrategy() == models.OracleStrategy.ALL)/*35.312*/{_display_(Seq(format.raw/*35.313*/("""
		void checkInvariant()
		"""),format.raw("""{"""),format.raw/*37.4*/("""
			// implement something to check the state invariants
		"""),format.raw("""}"""),format.raw/*39.4*/("""
		""")))})),format.raw/*40.4*/("""
		"""),_display_(Seq(/*41.4*/for(testCase <- testSuite.getTestCases()) yield /*41.45*/{_display_(Seq(format.raw/*41.46*/("""
		/**
		* Test Case """),_display_(Seq(/*43.16*/testCase/*43.24*/.getId())),format.raw/*43.32*/("""
		* Formula: """),_display_(Seq(/*44.15*/testCase/*44.23*/.getFormula())),format.raw/*44.36*/("""
		*/
		void testCase"""),_display_(Seq(/*46.17*/(testCase.getId()))),format.raw/*46.35*/("""()
		"""),format.raw("""{"""),format.raw/*47.4*/("""
			"""),_display_(Seq(/*48.5*/if(!testCase.getStateVariables().isEmpty())/*48.48*/{_display_(Seq(format.raw/*48.49*/("""// State """)))})),format.raw/*48.59*/(""" """),format.raw/*48.92*/(""" """),_display_(Seq(/*48.94*/for(variable <- testCase.getStateVariables()) yield /*48.139*/{_display_(Seq(format.raw/*48.140*/("""
			"""),_display_(Seq(/*49.5*/(builder.variableDeclaration(testCase.getFormula(), variable.getIdentifier(), false) + " = " + builder.variableAttribution(testCase.getFormula(), variable.getIdentifier(), variable.getValues())))),format.raw/*49.199*/(""";
			"""),_display_(Seq(/*50.5*/(builder.setCall(className.toLowerCase(), variable.getIdentifier())))),format.raw/*50.73*/(""";
			""")))})),format.raw/*51.5*/(""" """),format.raw/*51.32*/("""
			"""),_display_(Seq(/*52.5*/if(!testCase.getOperationParameters().isEmpty())/*52.53*/{_display_(Seq(format.raw/*52.54*/("""// Input Values """)))})),format.raw/*52.71*/(""" """),format.raw/*52.104*/(""" """),_display_(Seq(/*52.106*/for(parameter <- testCase.getOperationParameters()) yield /*52.157*/{_display_(Seq(format.raw/*52.158*/("""
			"""),_display_(Seq(/*53.5*/(builder.variableDeclaration(testCase.getFormula(), parameter.getIdentifier(), false) + " = " + builder.variableAttribution(testCase.getFormula(), parameter.getIdentifier(), parameter.getValues()) + ";"))),format.raw/*53.208*/("""
			""")))})),format.raw/*54.5*/(""" """),format.raw/*54.32*/("""
			"""),_display_(Seq(/*55.5*/if(testCase.hasReturn() && (testSuite.getOracleStrategy() == models.OracleStrategy.RETURN_VALUES || testSuite.getOracleStrategy() == models.OracleStrategy.STATE_INVARIANT_RETURN_VALUES || testSuite.getOracleStrategy() == models.OracleStrategy.STATE_VARIABLES_RETURN_VALUES || testSuite.getOracleStrategy() == models.OracleStrategy.ALL))/*55.341*/{_display_(Seq(format.raw/*55.342*/("""
			CPPUNIT_ASSERT( """),_display_(Seq(/*56.21*/(builder.operationCall(className.toLowerCase(), testSuite.getOperationUnderTest(), testCase.getOperationParameters())))),format.raw/*56.139*/(""" == /* Add expected value here */ );
			""")))}/*57.6*/else/*57.11*/{_display_(Seq(format.raw/*57.12*/("""
			"""),_display_(Seq(/*58.5*/(builder.operationCall(className.toLowerCase(), testSuite.getOperationUnderTest(), testCase.getOperationParameters())))),format.raw/*58.123*/(""";
			""")))})),format.raw/*59.5*/("""
			"""),_display_(Seq(/*60.5*/if(testSuite.getOracleStrategy() == models.OracleStrategy.STATE_VARIABLES || testSuite.getOracleStrategy() == models.OracleStrategy.STATE_INVARIANT_VARIABLES || testSuite.getOracleStrategy() == models.OracleStrategy.STATE_VARIABLES_RETURN_VALUES || testSuite.getOracleStrategy() == models.OracleStrategy.ALL)/*60.313*/{_display_(Seq(format.raw/*60.314*/("""
			"""),_display_(Seq(/*61.5*/for(variable <- testCase.getStateVariables()) yield /*61.50*/{_display_(Seq(format.raw/*61.51*/("""
			"""),_display_(Seq(/*62.5*/(builder.variableDeclaration(testCase.getFormula(), variable.getIdentifier(), true)))),format.raw/*62.89*/(""";	// Add expected value here.
			CPPUNIT_ASSERT( """),_display_(Seq(/*63.21*/(builder.getCall(className.toLowerCase(), variable.getIdentifier()) + " == " + variable.getIdentifier() + "Expected"))),format.raw/*63.138*/(""" );
			""")))})),format.raw/*64.5*/(""" """),format.raw/*64.32*/(""" """)))})),format.raw/*64.34*/(""" """),format.raw/*64.47*/("""	
			"""),_display_(Seq(/*65.5*/if(testSuite.getOracleStrategy() == models.OracleStrategy.STATE_INVARIANT || testSuite.getOracleStrategy() == models.OracleStrategy.STATE_INVARIANT_RETURN_VALUES || testSuite.getOracleStrategy() == models.OracleStrategy.STATE_INVARIANT_VARIABLES || testSuite.getOracleStrategy() == models.OracleStrategy.ALL)/*65.313*/{_display_(Seq(format.raw/*65.314*/("""
			checkInvariant(); // calling check invariant
			""")))})),format.raw/*67.5*/("""
		"""),format.raw("""}"""),format.raw/*68.4*/("""
		""")))})),format.raw/*69.4*/("""
"""),format.raw("""}"""),format.raw/*70.2*/(""" 
""")))})),format.raw/*71.2*/("""
"""))}
    }

    def render(builder:builders.CppUnitBuilder,testSuite:models.TestSuite) = apply(builder,testSuite)

    def f:((builders.CppUnitBuilder,models.TestSuite) => twirl.api.Txt) = (builder,testSuite) => apply(builder,testSuite)

    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Jan 04 00:26:19 BRT 2014
                    SOURCE: /Users/joaosouza/Documents/Mestrado/Repositorios/betaunittestgenerator/br.ufrn.forall.betaunittestgenerator/src/main/twirl/templates/CppUnitTemplate.scala.txt
                    HASH: f9e83c7af9c4f45662c8d3d817a3fdd63608c8e8
                    MATRIX: 293->1|418->64|578->195|622->231|668->245|716->263|733->272|771->289|816->304|833->313|878->337|935->363|953->372|998->395|1055->421|1073->430|1122->457|1174->478|1192->487|1248->521|1289->532|1341->562|1419->594|1473->617|1525->647|1561->653|1618->694|1652->695|1708->720|1748->738|1785->744|1858->787|1891->798|1925->801|1972->826|2049->857|2084->862|2131->887|2170->895|2203->906|2254->911|2325->936|2368->948|2415->973|2466->978|2500->982|2818->1290|2853->1291|2927->1319|3033->1379|3068->1383|3102->1387|3159->1428|3193->1429|3246->1451|3263->1459|3293->1467|3339->1482|3356->1490|3391->1503|3444->1525|3484->1543|3536->1549|3571->1554|3623->1597|3657->1598|3699->1608|3728->1641|3761->1643|3823->1688|3858->1689|3893->1694|4110->1888|4146->1894|4236->1962|4273->1968|4302->1995|4337->2000|4394->2048|4428->2049|4477->2066|4507->2099|4541->2101|4609->2152|4644->2153|4679->2158|4905->2361|4941->2366|4970->2393|5005->2398|5351->2734|5386->2735|5438->2756|5579->2874|5638->2916|5651->2921|5685->2922|5720->2927|5861->3045|5898->3051|5933->3056|6251->3364|6286->3365|6321->3370|6382->3415|6416->3416|6451->3421|6557->3505|6638->3555|6778->3672|6817->3680|6846->3707|6880->3709|6909->3722|6945->3728|7263->4036|7298->4037|7382->4090|7432->4094|7467->4098|7515->4100|7549->4103
                    LINES: 12->1|15->1|19->5|19->5|19->5|21->7|21->7|21->7|22->8|22->8|22->8|24->10|24->10|24->10|25->11|25->11|25->11|26->12|26->12|26->12|28->14|28->14|29->15|30->16|30->16|31->17|31->17|31->17|32->18|32->18|33->19|37->23|37->23|37->23|37->23|41->27|42->28|42->28|42->28|42->28|43->29|46->32|47->33|47->33|48->34|49->35|49->35|49->35|51->37|53->39|54->40|55->41|55->41|55->41|57->43|57->43|57->43|58->44|58->44|58->44|60->46|60->46|61->47|62->48|62->48|62->48|62->48|62->48|62->48|62->48|62->48|63->49|63->49|64->50|64->50|65->51|65->51|66->52|66->52|66->52|66->52|66->52|66->52|66->52|66->52|67->53|67->53|68->54|68->54|69->55|69->55|69->55|70->56|70->56|71->57|71->57|71->57|72->58|72->58|73->59|74->60|74->60|74->60|75->61|75->61|75->61|76->62|76->62|77->63|77->63|78->64|78->64|78->64|78->64|79->65|79->65|79->65|81->67|82->68|83->69|84->70|85->71
                    -- GENERATED --
                */
            