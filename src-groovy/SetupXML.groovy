import groovy.xml.MarkupBuilder
import groovy.xml.StreamingMarkupBuilder
import groovy.util.XmlSlurper

class SetupXML {
	public static String generateXML(){
		def writer = new StringWriter()
		def xml = new MarkupBuilder(writer)
		
		xml.records() {
			car(name:'HSV Maloo', make:'Holden', year:2006) {
				country('Australia')
				record(type:'speed', 'Production Pickup Truck with speed of 271kph')
			}
			car(name:'Royale', make:'Bugatti', year:1931) {
				country('France')
				record(type:'price', 'Most Valuable Car at $15 million')
			}
		}
		def records = new XmlSlurper().parseText(writer.toString());
		def name = records.name.toString();
		println name
		return "ok"
	}
	static void main(String[] args) {
		 def rs = generateXML()
		 println rs
	}
}