/**
 * Description: 【Webservice Config Object】 <br/>
 * Created on 15:40 2017/8/3 <br/>
 */
public class WsdlConfig {
    private String id;
    private String name;
    private String explain;
    private String wsdlLocation;
    private String operaionName;
    private String portName;
    private String request;
    private String response;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public String getWsdlLocation() {
        return wsdlLocation;
    }

    public void setWsdlLocation(String wsdlLocation) {
        this.wsdlLocation = wsdlLocation;
    }

    public String getOperaionName() {
        return operaionName;
    }

    public void setOperaionName(String operaionName) {
        this.operaionName = operaionName;
    }

    public String getPortName() {
        return portName;
    }

    public void setPortName(String portName) {
        this.portName = portName;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
