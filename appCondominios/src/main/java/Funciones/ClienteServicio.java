package Funciones;

import android.os.AsyncTask;
import android.util.Log;

import java.net.Proxy;
import java.util.LinkedList;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

/**
 * Created by Adrian on 08/01/2016.
 */
public class ClienteServicio extends AsyncTask {


    public ClienteServicio(){

    }

    @Override
    protected Object doInBackground(Object[] params) {
        return null;
    }

    private SoapSerializationEnvelope getSoapSerializationEnvelope(SoapObject soapobject)
    {
        SoapSerializationEnvelope soapserializationenvelope = new SoapSerializationEnvelope(110);
        soapserializationenvelope.dotNet = true;
        soapserializationenvelope.implicitTypes = true;
        soapserializationenvelope.setAddAdornments(false);
        soapserializationenvelope.setOutputSoapObject(soapobject);
        return soapserializationenvelope;
    }
    public String lfAutenticar(String s, String s1) {

          /* SoapObject soapobject = new SoapObject("http://cisaweb.com/", "Autentica");
        soapobject.addProperty("SecurityUser", s);
        soapobject.addProperty("SecurityPassword", s1);
        SoapSerializationEnvelope envelope =
                new SoapSerializationEnvelope(SoapEnvelope.VER11);

        envelope.dotNet = true;

        envelope.setOutputSoapObject(soapobject);
        HttpTransportSE transporte = new HttpTransportSE(Proxy.NO_PROXY,"https://www.cisaweb.com:443/wsCisaApp/service.asmx",60000);
        try {
            transporte.call("http://cisaweb.com/Autentica", envelope);
            SoapPrimitive resultado_xml = (SoapPrimitive) envelope.getResponse();
            String res = resultado_xml.toString();
            System.out.println("VEEEEEEEEEEEEEEEEAA::::"+res);
            if (res.equals("2015")) {
                return true;
            } else {
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
            return  false;
        }
        }*/
        SoapObject soapobject = new SoapObject("http://cisaweb.com/", "Autentica");
        soapobject.addProperty("SecurityUser", s);
        soapobject.addProperty("SecurityPassword", s1);
        SoapSerializationEnvelope envelope =
                new SoapSerializationEnvelope(SoapEnvelope.VER11);

        envelope.dotNet = true;

        envelope.setOutputSoapObject(soapobject);
        HttpTransportSE transporte = new HttpTransportSE(Proxy.NO_PROXY,"https://www.cisaweb.com:443/wsAppCondominios/service.asmx",60000);
        try {
            transporte.call("http://cisaweb.com/Autentica", envelope);
            SoapPrimitive resultado_xml = (SoapPrimitive) envelope.getResponse();
            String res = resultado_xml.toString();
            System.out.println("VEEEEEEEEEEEEEEEEAA::::"+res);
            if (res.equals("2015")) {
                return "true";
            } else {
                return "false";
            }
        }catch (Exception e){
            e.printStackTrace();
            return  "con";
        }




    }
}

