import groovy.util.XmlParser;
import groovy.util.XmlSlurper;
import groovy.xml.*;

class ParseXML {
	public static HashMap<String,String> ParseBRMXMLResult(String brmData,String modelName,List<String> brmList) {
	 
		def config = new HashMap<String,String>();
 
		def text = brmData.replace('&lt;', '<' ).replace( '&gt;', '>' )
		def response = new XmlParser().parseText(text)
	    
		
		brmList.eachWithIndex { it, i ->
			config.put(it,response["results"]["execution-results"]["result"]["$modelName"]["$it"].text());
			
		}
		
		return config;
	}
	
	
	
	public static HashMap ParseReputateFileTrackableRs(String envelopSOAPRs){
		
		def config = new HashMap();
		def Trackable_allRs = envelopSOAPRs.replace('&lt;', '<' ).replace( '&gt;', '>' );
		def slurper = new XmlSlurper().parseText(Trackable_allRs);
		def result = slurper.Body.reputateFileTrackableResponse.reputateFileTrackableResult;
		def branchs = result.branchInfo
	
		
		config.put('branchInfo',branchs)
		config.put('status',result.status.toString())
		config.put('Branchstatus',result.Branchstatus.toString())
		config.put('errorCode',result.errorCode.toString())
		return config
		
	}
	
	public static HashMap ParseReputationTrackableallRs(String envelopSOAPRs){
		
		def config = new HashMap();
		def Trackable_allRs = envelopSOAPRs.replace('&lt;', '<' ).replace( '&gt;', '>' );
		def slurper = new XmlSlurper().parseText(Trackable_allRs);
		//def result = slurper.Body.getReputation_allResponse.getReputation_allResult;
		def result = slurper.Body.getReputationTrackable_allResponse.getReputationTrackable_allResult;								 
		def branchs = result.branchInfo;	
	
		config.put('branchInfo',branchs)
		config.put('status',result.status.toString())
		config.put('Branchstatus',result.Branchstatus.toString())
		config.put('errorCode',result.errorCode.toString())
		return config
		
	}

	static void main(String[] args) {
	   //println ParseBRMXMLResult(args[0],args[1],args[2])
		/*
		String data = '''<?xml version="1.0" encoding="utf-8"?>
<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema">
	<soap:Body>
		<getReputationTrackable_allResponse xmlns="http://tempuri.org/">
			<getReputationTrackable_allResult>
				<status>Indeterminable</status>
				<errorCode />
			</getReputationTrackable_allResult>
		</getReputationTrackable_allResponse>
	</soap:Body>
</soap:Envelope>'''
		println ParseReputationTrackableallRs(data).get('status').toString()
*/
		
	}
 }
