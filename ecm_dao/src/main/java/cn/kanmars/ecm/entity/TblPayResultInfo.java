/**
 * ecm Generator 
 */
package cn.kanmars.ecm.entity;


/**
 * 支付结果通知表
 * tbl_pay_result_info
 */
public class TblPayResultInfo implements java.io.Serializable{
    /**
     * id
     * tbl_pay_result_info.id
     */
    private Integer id;

    /**
     * 公众账号ID
     * tbl_pay_result_info.appid
     */
    private String appid;

    /**
     * 商户号
     * tbl_pay_result_info.mch_id
     */
    private String mchId;

    /**
     * 设备号
     * tbl_pay_result_info.device_info
     */
    private String deviceInfo;

    /**
     * 随机字符串
     * tbl_pay_result_info.nonce_str
     */
    private String nonceStr;

    /**
     * 签名
     * tbl_pay_result_info.sign
     */
    private String sign;

    /**
     * 签名类型
     * tbl_pay_result_info.sign_type
     */
    private String signType;

    /**
     * 支付结果
     * tbl_pay_result_info.result_code
     */
    private String resultCode;

    /**
     * 错误代码
     * tbl_pay_result_info.err_code
     */
    private String errCode;

    /**
     * 错误代码描述
     * tbl_pay_result_info.err_code_des
     */
    private String errCodeDes;

    /**
     * 用户标识ID
     * tbl_pay_result_info.openid
     */
    private String openid;

    /**
     * 是否关注公众账号
     * tbl_pay_result_info.is_subscribe
     */
    private String isSubscribe;

    /**
     * 交易类型
     * tbl_pay_result_info.trade_type
     */
    private String tradeType;

    /**
     * 付款银行
     * tbl_pay_result_info.bank_type
     */
    private String bankType;

    /**
     * 订单金额
     * tbl_pay_result_info.total_fee
     */
    private String totalFee;

    /**
     * 应结订单金额
     * tbl_pay_result_info.settlement_total_fee
     */
    private String settlementTotalFee;

    /**
     * 货币种类
     * tbl_pay_result_info.fee_type
     */
    private String feeType;

    /**
     * 现金支付金额
     * tbl_pay_result_info.cash_fee
     */
    private String cashFee;

    /**
     * 现金支付货币类型
     * tbl_pay_result_info.cash_fee_type
     */
    private String cashFeeType;

    /**
     * 总代金券金额
     * tbl_pay_result_info.coupon_fee
     */
    private String couponFee;

    /**
     * 代金券使用数量
     * tbl_pay_result_info.coupon_count
     */
    private String couponCount;

    /**
     * 代金券类型
     * tbl_pay_result_info.coupon_type
     */
    private String couponType;

    /**
     * 代金券ID
     * tbl_pay_result_info.coupon_id
     */
    private String couponId;

    /**
     * 单个代金券支付金额
     * tbl_pay_result_info.coupon_fee_one
     */
    private String couponFeeOne;

    /**
     * 微信支付订单号
     * tbl_pay_result_info.transaction_idtransaction_id
     */
    private String transactionIdtransactionId;

    /**
     * 商户订单号
     * tbl_pay_result_info.out_trade_no
     */
    private String outTradeNo;

    /**
     * 支付完成时间
     * tbl_pay_result_info.time_end
     */
    private String timeEnd;

    /**
     * 创建时间
     * tbl_pay_result_info.create_time
     */
    private String createTime;

    /**
     * 创建人
     * tbl_pay_result_info.create_user
     */
    private String createUser;


    public TblPayResultInfo(){super();}
    public TblPayResultInfo(Integer id,String appid,String mchId,String deviceInfo,String nonceStr,String sign,String signType,String resultCode,String errCode,String errCodeDes,String openid,String isSubscribe,String tradeType,String bankType,String totalFee,String settlementTotalFee,String feeType,String cashFee,String cashFeeType,String couponFee,String couponCount,String couponType,String couponId,String couponFeeOne,String transactionIdtransactionId,String outTradeNo,String timeEnd,String createTime,String createUser) {
        this.id = id;
        this.appid = appid;
        this.mchId = mchId;
        this.deviceInfo = deviceInfo;
        this.nonceStr = nonceStr;
        this.sign = sign;
        this.signType = signType;
        this.resultCode = resultCode;
        this.errCode = errCode;
        this.errCodeDes = errCodeDes;
        this.openid = openid;
        this.isSubscribe = isSubscribe;
        this.tradeType = tradeType;
        this.bankType = bankType;
        this.totalFee = totalFee;
        this.settlementTotalFee = settlementTotalFee;
        this.feeType = feeType;
        this.cashFee = cashFee;
        this.cashFeeType = cashFeeType;
        this.couponFee = couponFee;
        this.couponCount = couponCount;
        this.couponType = couponType;
        this.couponId = couponId;
        this.couponFeeOne = couponFeeOne;
        this.transactionIdtransactionId = transactionIdtransactionId;
        this.outTradeNo = outTradeNo;
        this.timeEnd = timeEnd;
        this.createTime = createTime;
        this.createUser = createUser;
    }
    /**
     * id
     * tbl_pay_result_info.id
     */
    public Integer getId(){
        return id;
    }

    /**
     * id
     * tbl_pay_result_info.id
     */
    public void setId(Integer id){
        this.id=id;
    }

    /**
     * 公众账号ID
     * tbl_pay_result_info.appid
     */
    public String getAppid(){
        return appid;
    }

    /**
     * 公众账号ID
     * tbl_pay_result_info.appid
     */
    public void setAppid(String appid){
        this.appid=appid;
    }

    /**
     * 商户号
     * tbl_pay_result_info.mch_id
     */
    public String getMchId(){
        return mchId;
    }

    /**
     * 商户号
     * tbl_pay_result_info.mch_id
     */
    public void setMchId(String mchId){
        this.mchId=mchId;
    }

    /**
     * 设备号
     * tbl_pay_result_info.device_info
     */
    public String getDeviceInfo(){
        return deviceInfo;
    }

    /**
     * 设备号
     * tbl_pay_result_info.device_info
     */
    public void setDeviceInfo(String deviceInfo){
        this.deviceInfo=deviceInfo;
    }

    /**
     * 随机字符串
     * tbl_pay_result_info.nonce_str
     */
    public String getNonceStr(){
        return nonceStr;
    }

    /**
     * 随机字符串
     * tbl_pay_result_info.nonce_str
     */
    public void setNonceStr(String nonceStr){
        this.nonceStr=nonceStr;
    }

    /**
     * 签名
     * tbl_pay_result_info.sign
     */
    public String getSign(){
        return sign;
    }

    /**
     * 签名
     * tbl_pay_result_info.sign
     */
    public void setSign(String sign){
        this.sign=sign;
    }

    /**
     * 签名类型
     * tbl_pay_result_info.sign_type
     */
    public String getSignType(){
        return signType;
    }

    /**
     * 签名类型
     * tbl_pay_result_info.sign_type
     */
    public void setSignType(String signType){
        this.signType=signType;
    }

    /**
     * 支付结果
     * tbl_pay_result_info.result_code
     */
    public String getResultCode(){
        return resultCode;
    }

    /**
     * 支付结果
     * tbl_pay_result_info.result_code
     */
    public void setResultCode(String resultCode){
        this.resultCode=resultCode;
    }

    /**
     * 错误代码
     * tbl_pay_result_info.err_code
     */
    public String getErrCode(){
        return errCode;
    }

    /**
     * 错误代码
     * tbl_pay_result_info.err_code
     */
    public void setErrCode(String errCode){
        this.errCode=errCode;
    }

    /**
     * 错误代码描述
     * tbl_pay_result_info.err_code_des
     */
    public String getErrCodeDes(){
        return errCodeDes;
    }

    /**
     * 错误代码描述
     * tbl_pay_result_info.err_code_des
     */
    public void setErrCodeDes(String errCodeDes){
        this.errCodeDes=errCodeDes;
    }

    /**
     * 用户标识ID
     * tbl_pay_result_info.openid
     */
    public String getOpenid(){
        return openid;
    }

    /**
     * 用户标识ID
     * tbl_pay_result_info.openid
     */
    public void setOpenid(String openid){
        this.openid=openid;
    }

    /**
     * 是否关注公众账号
     * tbl_pay_result_info.is_subscribe
     */
    public String getIsSubscribe(){
        return isSubscribe;
    }

    /**
     * 是否关注公众账号
     * tbl_pay_result_info.is_subscribe
     */
    public void setIsSubscribe(String isSubscribe){
        this.isSubscribe=isSubscribe;
    }

    /**
     * 交易类型
     * tbl_pay_result_info.trade_type
     */
    public String getTradeType(){
        return tradeType;
    }

    /**
     * 交易类型
     * tbl_pay_result_info.trade_type
     */
    public void setTradeType(String tradeType){
        this.tradeType=tradeType;
    }

    /**
     * 付款银行
     * tbl_pay_result_info.bank_type
     */
    public String getBankType(){
        return bankType;
    }

    /**
     * 付款银行
     * tbl_pay_result_info.bank_type
     */
    public void setBankType(String bankType){
        this.bankType=bankType;
    }

    /**
     * 订单金额
     * tbl_pay_result_info.total_fee
     */
    public String getTotalFee(){
        return totalFee;
    }

    /**
     * 订单金额
     * tbl_pay_result_info.total_fee
     */
    public void setTotalFee(String totalFee){
        this.totalFee=totalFee;
    }

    /**
     * 应结订单金额
     * tbl_pay_result_info.settlement_total_fee
     */
    public String getSettlementTotalFee(){
        return settlementTotalFee;
    }

    /**
     * 应结订单金额
     * tbl_pay_result_info.settlement_total_fee
     */
    public void setSettlementTotalFee(String settlementTotalFee){
        this.settlementTotalFee=settlementTotalFee;
    }

    /**
     * 货币种类
     * tbl_pay_result_info.fee_type
     */
    public String getFeeType(){
        return feeType;
    }

    /**
     * 货币种类
     * tbl_pay_result_info.fee_type
     */
    public void setFeeType(String feeType){
        this.feeType=feeType;
    }

    /**
     * 现金支付金额
     * tbl_pay_result_info.cash_fee
     */
    public String getCashFee(){
        return cashFee;
    }

    /**
     * 现金支付金额
     * tbl_pay_result_info.cash_fee
     */
    public void setCashFee(String cashFee){
        this.cashFee=cashFee;
    }

    /**
     * 现金支付货币类型
     * tbl_pay_result_info.cash_fee_type
     */
    public String getCashFeeType(){
        return cashFeeType;
    }

    /**
     * 现金支付货币类型
     * tbl_pay_result_info.cash_fee_type
     */
    public void setCashFeeType(String cashFeeType){
        this.cashFeeType=cashFeeType;
    }

    /**
     * 总代金券金额
     * tbl_pay_result_info.coupon_fee
     */
    public String getCouponFee(){
        return couponFee;
    }

    /**
     * 总代金券金额
     * tbl_pay_result_info.coupon_fee
     */
    public void setCouponFee(String couponFee){
        this.couponFee=couponFee;
    }

    /**
     * 代金券使用数量
     * tbl_pay_result_info.coupon_count
     */
    public String getCouponCount(){
        return couponCount;
    }

    /**
     * 代金券使用数量
     * tbl_pay_result_info.coupon_count
     */
    public void setCouponCount(String couponCount){
        this.couponCount=couponCount;
    }

    /**
     * 代金券类型
     * tbl_pay_result_info.coupon_type
     */
    public String getCouponType(){
        return couponType;
    }

    /**
     * 代金券类型
     * tbl_pay_result_info.coupon_type
     */
    public void setCouponType(String couponType){
        this.couponType=couponType;
    }

    /**
     * 代金券ID
     * tbl_pay_result_info.coupon_id
     */
    public String getCouponId(){
        return couponId;
    }

    /**
     * 代金券ID
     * tbl_pay_result_info.coupon_id
     */
    public void setCouponId(String couponId){
        this.couponId=couponId;
    }

    /**
     * 单个代金券支付金额
     * tbl_pay_result_info.coupon_fee_one
     */
    public String getCouponFeeOne(){
        return couponFeeOne;
    }

    /**
     * 单个代金券支付金额
     * tbl_pay_result_info.coupon_fee_one
     */
    public void setCouponFeeOne(String couponFeeOne){
        this.couponFeeOne=couponFeeOne;
    }

    /**
     * 微信支付订单号
     * tbl_pay_result_info.transaction_idtransaction_id
     */
    public String getTransactionIdtransactionId(){
        return transactionIdtransactionId;
    }

    /**
     * 微信支付订单号
     * tbl_pay_result_info.transaction_idtransaction_id
     */
    public void setTransactionIdtransactionId(String transactionIdtransactionId){
        this.transactionIdtransactionId=transactionIdtransactionId;
    }

    /**
     * 商户订单号
     * tbl_pay_result_info.out_trade_no
     */
    public String getOutTradeNo(){
        return outTradeNo;
    }

    /**
     * 商户订单号
     * tbl_pay_result_info.out_trade_no
     */
    public void setOutTradeNo(String outTradeNo){
        this.outTradeNo=outTradeNo;
    }

    /**
     * 支付完成时间
     * tbl_pay_result_info.time_end
     */
    public String getTimeEnd(){
        return timeEnd;
    }

    /**
     * 支付完成时间
     * tbl_pay_result_info.time_end
     */
    public void setTimeEnd(String timeEnd){
        this.timeEnd=timeEnd;
    }

    /**
     * 创建时间
     * tbl_pay_result_info.create_time
     */
    public String getCreateTime(){
        return createTime;
    }

    /**
     * 创建时间
     * tbl_pay_result_info.create_time
     */
    public void setCreateTime(String createTime){
        this.createTime=createTime;
    }

    /**
     * 创建人
     * tbl_pay_result_info.create_user
     */
    public String getCreateUser(){
        return createUser;
    }

    /**
     * 创建人
     * tbl_pay_result_info.create_user
     */
    public void setCreateUser(String createUser){
        this.createUser=createUser;
    }

    /**
     * 自定义列，分页查询用
     */
    private Integer limitStart;
    public Integer getLimitStart(){
        return limitStart;
    }
    public void setLimitStart(Integer limitStart){
        this.limitStart = limitStart;
    }
    private Integer limitSize;
    public Integer getLimitSize(){
        return limitSize;
    }
    public void setLimitSize(Integer limitSize){
        this.limitSize = limitSize;
    }
}

