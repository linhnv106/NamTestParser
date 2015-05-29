import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class NameTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NameTest test = new NameTest();
		try {
			test.getData();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	private Entry getData() throws Exception {
		String titleTAG ="fully-linked panel panel-start text-center pull-left";
		String title2TAG="<span class=\"h2\">";
		String imgTAG="Upload/Images/Chuongtrinh/";
		String linkTAG="file=Upload";
		String desTAG="itemprop=\"description\"";
		String timeTAG="article:published_time";
		String url = "http://en.nametests.com/?page=7";
		Entry entry = new Entry();
		URL obj = new URL(url);
		System.out.println("\nSending 'GET' request to URL : " + url);

		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		// optional default is GET
		con.setRequestMethod("GET");
 
		//add request header
 
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);
 
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream(),"UTF-8"));
		String inputLine;
		StringBuffer response = new StringBuffer();
	    boolean start=false;

		while ((inputLine = in.readLine()) != null) {
			String temp="";
			int index=0;
			if(inputLine.contains(titleTAG)){

				start=true;
				int imgIndex1=inputLine.indexOf("http://");
				int imgIndex2=inputLine.indexOf(".jpg");
				String imgUrl=inputLine.substring(imgIndex1, imgIndex2+4);
				int linkIndex=inputLine.indexOf("href=");
				String entryUrl=inputLine.substring(linkIndex+6, inputLine.length()-2);
				entry.setUrl(entryUrl);
				entry.setBackground(imgUrl);

			}

			if(start&&inputLine.contains(title2TAG)){
				int titleIndex=inputLine.indexOf("<span class=\"h2\">");
				String title=inputLine.substring(titleIndex+17, inputLine.length()-7);
				start=false;
				entry.setTitle(title);
				System.out.println(" \n\n" +entry);

			}
		
		}
		in.close();
 

		return null;
 
	}

}
