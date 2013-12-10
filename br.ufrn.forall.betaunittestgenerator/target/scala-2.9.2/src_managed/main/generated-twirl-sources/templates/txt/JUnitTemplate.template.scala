
package templates.txt

import twirl.api._
import TemplateMagic._


/**/
object JUnitTemplate extends BaseScalaTemplate[twirl.api.Txt,Format[twirl.api.Txt]](twirl.api.TxtFormat) with twirl.api.Template2[builders.JUnitBuilder,models.TestSuite,twirl.api.Txt] {

    /**/
    def apply/*1.2*/(builder: builders.JUnitBuilder, testSuite: models.TestSuite):twirl.api.Txt = {
        _display_ {

Seq(format.raw/*1.63*/("""
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
"""),_display_(Seq(/*6.2*/defining(testSuite.getMachineName())/*6.38*/{ className =>_display_(Seq(format.raw/*6.52*/("""
/**
* Machine: """),_display_(Seq(/*8.13*/testSuite/*8.22*/.getMachineName())),format.raw/*8.39*/("""
* Operation: """),_display_(Seq(/*9.15*/testSuite/*9.24*/.getOperationUnderTest())),format.raw/*9.48*/("""
*
* Partition Strategy: """),_display_(Seq(/*11.24*/testSuite/*11.33*/.getPartitionStrategy())),format.raw/*11.56*/("""
* Combination Strategy: """),_display_(Seq(/*12.26*/testSuite/*12.35*/.getCombinatorialCriteria())),format.raw/*12.62*/("""
* Oracle Strategy: """),_display_(Seq(/*13.21*/testSuite/*13.30*/.getOracleStrategy().getStrategy())),format.raw/*13.64*/("""
*/
public class """),_display_(Seq(/*15.15*/{builder.className(testSuite)})),format.raw/*15.45*/(""" """),format.raw("""{"""),format.raw/*15.47*/(""" 

	private """),_display_(Seq(/*17.11*/(className))),format.raw/*17.22*/(""" """),_display_(Seq(/*17.24*/(className.toLowerCase()))),format.raw/*17.49*/(""";

	@Before
	public void setUp() throws Exception """),format.raw("""{"""),format.raw/*20.40*/("""
		"""),_display_(Seq(/*21.4*/(className.toLowerCase()))),format.raw/*21.29*/(""" = new """),_display_(Seq(/*21.37*/(className))),format.raw/*21.48*/("""();
	"""),format.raw("""}"""),format.raw/*22.3*/(""" 
	"""),_display_(Seq(/*23.3*/if(testSuite.getOracleStrategy() == models.OracleStrategy.STATE_INVARIANT || testSuite.getOracleStrategy() == models.OracleStrategy.STATE_INVARIANT_RETURN_VALUES || testSuite.getOracleStrategy() == models.OracleStrategy.STATE_INVARIANT_VARIABLES || testSuite.getOracleStrategy() == models.OracleStrategy.ALL)/*23.311*/{_display_(Seq(format.raw/*23.312*/("""
	@After
	public void checkInvariant() throws Exception """),format.raw("""{"""),format.raw/*25.49*/("""
		// implement something to check the state invariants
	"""),format.raw("""}"""),format.raw/*27.3*/("""
	""")))})),format.raw/*28.3*/("""
	"""),_display_(Seq(/*29.3*/for(testCase <- testSuite.getTestCases()) yield /*29.44*/{_display_(Seq(format.raw/*29.45*/("""
	/**
	* Test Case """),_display_(Seq(/*31.15*/testCase/*31.23*/.getId())),format.raw/*31.31*/("""
	* Formula: """),_display_(Seq(/*32.14*/testCase/*32.22*/.getFormula())),format.raw/*32.35*/("""
	*/
	@Test
	public void testCase"""),_display_(Seq(/*35.23*/(testCase.getId()))),format.raw/*35.41*/(""" """),format.raw("""{"""),format.raw/*35.43*/("""
		"""),_display_(Seq(/*36.4*/if(!testCase.getStateVariables().isEmpty())/*36.47*/{_display_(Seq(format.raw/*36.48*/("""// State """)))})),format.raw/*36.58*/(""" """),format.raw/*36.91*/(""" """),_display_(Seq(/*36.93*/for(variable <- testCase.getStateVariables()) yield /*36.138*/{_display_(Seq(format.raw/*36.139*/("""
		"""),_display_(Seq(/*37.4*/(builder.variableDeclaration(testCase.getFormula(), variable.getIdentifier()) + " = " + builder.variableAttribution(testCase.getFormula(), variable.getIdentifier(), variable.getValues())))),format.raw/*37.191*/(""";
		"""),_display_(Seq(/*38.4*/(builder.setCall(className.toLowerCase(), variable.getIdentifier())))),format.raw/*38.72*/(""";
		""")))})),format.raw/*39.4*/(""" """),format.raw/*39.31*/("""
		"""),_display_(Seq(/*40.4*/if(!testCase.getOperationParameters().isEmpty())/*40.52*/{_display_(Seq(format.raw/*40.53*/("""// Input Values """)))})),format.raw/*40.70*/(""" """),format.raw/*40.103*/(""" """),_display_(Seq(/*40.105*/for(parameter <- testCase.getOperationParameters()) yield /*40.156*/{_display_(Seq(format.raw/*40.157*/("""
		"""),_display_(Seq(/*41.4*/(builder.variableDeclaration(testCase.getFormula(), parameter.getIdentifier()) + " = " + builder.variableAttribution(testCase.getFormula(), parameter.getIdentifier(), parameter.getValues()) + ";"))),format.raw/*41.200*/("""
		""")))})),format.raw/*42.4*/(""" """),format.raw/*42.31*/("""
		"""),_display_(Seq(/*43.4*/if(testCase.hasReturn() && (testSuite.getOracleStrategy() == models.OracleStrategy.RETURN_VALUES || testSuite.getOracleStrategy() == models.OracleStrategy.STATE_INVARIANT_RETURN_VALUES || testSuite.getOracleStrategy() == models.OracleStrategy.STATE_VARIABLES_RETURN_VALUES || testSuite.getOracleStrategy() == models.OracleStrategy.ALL))/*43.340*/{_display_(Seq(format.raw/*43.341*/("""
		assertEquals("""),_display_(Seq(/*44.17*/(builder.operationCall(className.toLowerCase(), testSuite.getOperationUnderTest(), testCase.getOperationParameters())))),format.raw/*44.135*/(""", /* Add expected value here */);
		""")))}/*45.5*/else/*45.10*/{_display_(Seq(format.raw/*45.11*/("""
		"""),_display_(Seq(/*46.4*/(builder.operationCall(className.toLowerCase(), testSuite.getOperationUnderTest(), testCase.getOperationParameters())))),format.raw/*46.122*/(""";
		""")))})),format.raw/*47.4*/("""
		"""),_display_(Seq(/*48.4*/if(testSuite.getOracleStrategy() == models.OracleStrategy.STATE_VARIABLES || testSuite.getOracleStrategy() == models.OracleStrategy.STATE_INVARIANT_VARIABLES || testSuite.getOracleStrategy() == models.OracleStrategy.STATE_VARIABLES_RETURN_VALUES || testSuite.getOracleStrategy() == models.OracleStrategy.ALL)/*48.312*/{_display_(Seq(format.raw/*48.313*/("""
		"""),_display_(Seq(/*49.4*/for(variable <- testCase.getStateVariables()) yield /*49.49*/{_display_(Seq(format.raw/*49.50*/("""
		"""),_display_(Seq(/*50.4*/(builder.variableDeclaration(testCase.getFormula(), variable.getIdentifier()) + "Expected"))),format.raw/*50.95*/(""";	// Add expected value here.
		assertEquals("""),_display_(Seq(/*51.17*/(builder.getCall(className.toLowerCase(), variable.getIdentifier()) + ", " + variable.getIdentifier() + "Expected"))),format.raw/*51.132*/(""");
		""")))})),format.raw/*52.4*/(""" """),format.raw/*52.31*/(""" """)))})),format.raw/*52.33*/(""" """),format.raw/*52.46*/("""
	"""),format.raw("""}"""),format.raw/*53.3*/("""
	""")))})),format.raw/*54.3*/("""
"""),format.raw("""}"""),format.raw/*55.2*/("""
""")))})))}
    }

    def render(builder:builders.JUnitBuilder,testSuite:models.TestSuite) = apply(builder,testSuite)

    def f:((builders.JUnitBuilder,models.TestSuite) => twirl.api.Txt) = (builder,testSuite) => apply(builder,testSuite)

    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Dec 10 19:09:27 BRT 2013
                    SOURCE: /Users/joaosouza/Documents/Mestrado/Repositorios/betaunittestgenerator/br.ufrn.forall.betaunittestgenerator/src/main/twirl/templates/JUnitTemplate.scala.txt
                    HASH: 61715b70496870e17b07def4743babd840461e39
                    MATRIX: 289->1|412->62|549->170|593->206|639->220|686->237|703->246|741->263|786->278|803->287|848->311|905->337|923->346|968->369|1025->395|1043->404|1092->431|1144->452|1162->461|1218->495|1267->513|1319->543|1368->545|1412->558|1445->569|1478->571|1525->596|1623->648|1657->652|1704->677|1743->685|1776->696|1828->702|1862->706|2180->1014|2215->1015|2319->1073|2423->1131|2457->1134|2490->1137|2547->1178|2581->1179|2632->1199|2649->1207|2679->1215|2724->1229|2741->1237|2776->1250|2841->1285|2881->1303|2930->1305|2964->1309|3016->1352|3050->1353|3092->1363|3121->1396|3154->1398|3216->1443|3251->1444|3285->1448|3495->1635|3530->1640|3620->1708|3656->1713|3685->1740|3719->1744|3776->1792|3810->1793|3859->1810|3889->1843|3923->1845|3991->1896|4026->1897|4060->1901|4279->2097|4314->2101|4343->2128|4377->2132|4723->2468|4758->2469|4806->2486|4947->2604|5002->2642|5015->2647|5049->2648|5083->2652|5224->2770|5260->2775|5294->2779|5612->3087|5647->3088|5681->3092|5742->3137|5776->3138|5810->3142|5923->3233|6000->3279|6138->3394|6175->3400|6204->3427|6238->3429|6267->3442|6316->3445|6350->3448|6398->3450
                    LINES: 12->1|15->1|20->6|20->6|20->6|22->8|22->8|22->8|23->9|23->9|23->9|25->11|25->11|25->11|26->12|26->12|26->12|27->13|27->13|27->13|29->15|29->15|29->15|31->17|31->17|31->17|31->17|34->20|35->21|35->21|35->21|35->21|36->22|37->23|37->23|37->23|39->25|41->27|42->28|43->29|43->29|43->29|45->31|45->31|45->31|46->32|46->32|46->32|49->35|49->35|49->35|50->36|50->36|50->36|50->36|50->36|50->36|50->36|50->36|51->37|51->37|52->38|52->38|53->39|53->39|54->40|54->40|54->40|54->40|54->40|54->40|54->40|54->40|55->41|55->41|56->42|56->42|57->43|57->43|57->43|58->44|58->44|59->45|59->45|59->45|60->46|60->46|61->47|62->48|62->48|62->48|63->49|63->49|63->49|64->50|64->50|65->51|65->51|66->52|66->52|66->52|66->52|67->53|68->54|69->55
                    -- GENERATED --
                */
            