
        package com.isuwang.soa.service;

        import com.isuwang.dapeng.core.Processor;
        import com.isuwang.dapeng.core.Service;
        import com.isuwang.dapeng.core.SoaGlobalTransactional;

        /**
         * Autogenerated by Dapeng-Code-Generator (1.2.2)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated

        * 
        **/
        @Service(name="com.isuwang.soa.service.CalculateService",version = "1.0.0")
        @Processor(className = "com.isuwang.soa.CalculateServiceCodec$Processor")
        public interface CalculateService {
        
            /**
            * 
            **/
            
               
               Integer calcualteWordCount(String filename, String word) throws com.isuwang.dapeng.core.SoaException;
              
          
            /**
            * 
            **/
            
               
               java.util.Map<String, Integer> calcualteWordsCount(String fileName) throws com.isuwang.dapeng.core.SoaException;
              
          
        }
        