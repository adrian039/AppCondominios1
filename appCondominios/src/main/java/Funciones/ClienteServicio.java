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
    private final String strACCION_AUTENTICA = "http://cisaweb.com/Autentica";
    private final String strACCION_EXPORTARCOORDENADAS = "http://cisaweb.com/ExportarCoordenadas";
    private final String strACCION_EXPORTARFOTO = "http://cisaweb.com/ExportarFotos";
    private final String strACCION_EXPORTARLECTURAS = "http://cisaweb.com/ExportarLecturas";
    private final String strACCION_IMPORTARLECTURAS = "http://cisaweb.com/ImportarLecturas";
    private final String strACCION_IMPORTAR_ABONADOS = "http://cisaweb.com/ImportarAbonados";
    private final String strACCION_RECUPERARZONAS = "http://cisaweb.com/ImportarZonas";
    private final String strACCION_TEST = "http://cisaweb.com/TestConnection";
    private final String strMETODO_AUTENTICA = "Autentica";
    private final String strMETODO_EXPORTARCOORDENADAS = "ExportarCoordenadas";
    private final String strMETODO_EXPORTARFOTO = "ExportarFotos";
    private final String strMETODO_EXPORTARLECTURAS = "ExportarLecturas";
    private final String strMETODO_IMPORTARLECTURAS = "ImportarLecturas";
    private final String strMETODO_IMPORTAR_ABONADOS = "ImportarAbonados";
    private final String strMETODO_RECUPERARZONAS = "ImportarZonas";
    private final String strMETODO_TEST = "TestConnection";
    private final String strNAMESPACE = "http://cisaweb.com/";
    private final String strURL = "https://www.cisaweb.com:443/wsCisaApp/service.asmx";


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
    public boolean lfAutenticar(String s, String s1) {

          /*  SoapObject soapobject = new SoapObject("http://tempuri.org/", "Auntenticar");
            soapobject.addProperty("username", s);
            soapobject.addProperty("password", s1);
            SoapSerializationEnvelope envelope =
                    new SoapSerializationEnvelope(SoapEnvelope.VER11);

            envelope.dotNet = true;

            envelope.setOutputSoapObject(soapobject);
            HttpTransportSE transporte = new HttpTransportSE("http://10.0.2.2:55882/WebService1.asmx");
        try {
            transporte.call("http://tempuri.org/Auntenticar", envelope);
            SoapPrimitive resultado_xml = (SoapPrimitive) envelope.getResponse();
            String res = resultado_xml.toString();
            System.out.println("VEEEEEEEEEEEEEEEEAA::::"+res);
            if (res.equals("true")) {
                return true;
            } else {
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
            return  false;
        }*/
        SoapObject soapobject = new SoapObject("http://cisaweb.com/", "Autentica");
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
            if (res.equals("true")) {
                return true;
            } else {
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
            return  false;
        }




    }
}
