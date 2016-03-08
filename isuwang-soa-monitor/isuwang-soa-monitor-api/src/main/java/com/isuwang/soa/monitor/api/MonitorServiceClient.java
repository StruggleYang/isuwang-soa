package com.isuwang.soa.monitor.api;

import com.isuwang.soa.core.*;
import org.apache.thrift.*;
import com.isuwang.soa.remoting.BaseServiceClient;
import com.isuwang.soa.monitor.api.MonitorServiceCodec.*;

public class MonitorServiceClient extends BaseServiceClient {

    public MonitorServiceClient() {
        super("com.isuwang.soa.monitor.api.service.MonitorService", "1.0.0");
    }


    /**
     * 上送QPS信息
     **/
    public void uploadQPSStat(com.isuwang.soa.monitor.api.domain.QPSStat qpsStat) throws TException {
        initContext("uploadQPSStat");

        try {
            uploadQPSStat_args uploadQPSStat_args = new uploadQPSStat_args();
            uploadQPSStat_args.setQpsStat(qpsStat);


            uploadQPSStat_result response = sendBase(uploadQPSStat_args, new uploadQPSStat_result(), new UploadQPSStat_argsSerializer(), new UploadQPSStat_resultSerializer());


        } finally {
            destoryContext();
        }
    }

    /**
     * 上送平台处理数据
     **/
    public void uploadPlatformProcessData(com.isuwang.soa.monitor.api.domain.PlatformProcessData platformProcessData) throws TException {
        initContext("uploadPlatformProcessData");

        try {
            uploadPlatformProcessData_args uploadPlatformProcessData_args = new uploadPlatformProcessData_args();
            uploadPlatformProcessData_args.setPlatformProcessData(platformProcessData);


            uploadPlatformProcessData_result response = sendBase(uploadPlatformProcessData_args, new uploadPlatformProcessData_result(), new UploadPlatformProcessData_argsSerializer(), new UploadPlatformProcessData_resultSerializer());


        } finally {
            destoryContext();
        }
    }


    /**
     * getServiceMetadata
     **/
    public String getServiceMetadata() throws TException {
        initContext("getServiceMetadata");
        try {
            getServiceMetadata_args getServiceMetadata_args = new getServiceMetadata_args();
            getServiceMetadata_result response = sendBase(getServiceMetadata_args, new getServiceMetadata_result(), new GetServiceMetadata_argsSerializer(), new GetServiceMetadata_resultSerializer());
            return response.getSuccess();
        } finally {
            destoryContext();
        }
    }

}
      