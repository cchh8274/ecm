package cn.kanmars.ecm.aspect;

/**
 * Created by kanmars on 2017/8/22.
 */
public class ClusterTrack {
    public static final String CLUSTERTRACK="CLUSTERTRACK";
    private static ThreadLocal<String> clusterTrackInThreadLocal = new ThreadLocal<String>();
    public static String getClusterTrack(){
        return clusterTrackInThreadLocal.get();
    }
    public static void setClusterTrack(String value){
        clusterTrackInThreadLocal.set(value);
    }
}
