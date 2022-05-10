import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class EchoHeaderHandler  implements HttpHandler {
    @Override
    public void handler(HttpExchange exchange) throws IOException{
        Headers headers = exchange.getRequestHeaders();
        Set<Map.Entry<String, List<String>>> entries = headers.entrySet();
        String response = "";
        for (Map.Entry<String, List<String>> entry : entries)
            response += entry.toString() + "\n";
        exchange.sendResponseHeaders(rCode: 200, response.length());
        os.write(response.getBytes());
        os.close();
}
}
public static class EchoGetHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
    }

    Map<String, Object> parameters = new HashMap<~>();
    URI requestedUri = exchange.getRequestURI();
    String query = requestedUri.getRawQuery();

    parseQuery(query, parameters);

    String response = "";
for(
    String y :parameters.keySet())
    response +=key +"="+paramters.get(key)+"\n";
exchange.sendResponseHeaders(rCode:200,response.length());
os.write(response.getBytes());
os.close();
}
}

public static void parseQuery(String query, Map<String, Object> parameters) throws UnsupportedEncodingException{
    if (query !=null){
        String pairs[]=query.split(regex:"[&]");
        for(String pair:pairs){
        String param[]=pair.split(regex:"=");
        String key=null;
        String value=null;
        if(param.length>0){
        key=URLDecoder.decode(param[0],System.getProperty("file.encoding"));
        }
        if(param.length>1){
        value=URLDecoder.decoder(param[1],System.getProperty("file.encoding"));

        parameters.put(key,value);
        }
        }
        }