$(function(){
    searchUnionUnionDemoInfo('');
    $('#queryUnionUnionDemoInfopageSize').on('change',function () {
        var currentPage = $("#queryUnionUnionDemoInfocurrentPage").val();
        searchUnionUnionDemoInfo(currentPage);
    });
    
    //时间框校验函数，时间框在校验失败后，再点击，不会触发校验，因此手工触发
    function revalidateDate(formname,datefieldname){
        if($("#"+formname+"").data('bootstrapValidator')!=null
            && $("#"+formname+"").data('bootstrapValidator').validateField !=null)
        {
            $("#"+formname+"").data('bootstrapValidator').updateStatus(datefieldname,"NOT_VALIDATED",null);
            $("#"+formname+"").data('bootstrapValidator').validateField(datefieldname);
        }
    }
    //在模态框对用户完全可见后，清空所有的校验状态，经验证：
    // show.bs.modal，shown.bs.modal，hide.bs.modal	，hidden.bs.modal仅有  shown.bs.modal在功能上没问题，但是视觉上仍不太满意
    // 理论上说，最合适的是hidden.bs.modal，当模态框关闭时清空，但实际上未能生效，因此使用了shown.bs.modal
    $('#updateUnionUnionDemoInfo').on('shown.bs.modal', function () {
        $('#validateUpdateUnionUnionDemoInfoForm').bootstrapValidator('resetForm', false);
    });
    $("#queryUnionUnionDemoInfoForm #createTime").ECalendar({
        type:"time",
        stamp : false,
        offset:[0,2],
        format:"yyyy-mm-dd hh:ii:ss",
        skin:1,
        step:1,
        callback:function(v,e){revalidateDate("queryUnionUnionDemoInfoForm","createTime");} //回调函数
    });
    $("#validateAddUnionUnionDemoInfoForm #createTime1").ECalendar({
        type:"time",
        stamp : false,
        offset:[0,2],
        format:"yyyy-mm-dd hh:ii:ss",
        skin:1,
        step:1,
        callback:function(v,e){revalidateDate("validateAddUnionUnionDemoInfoForm","createTime1");} //回调函数
    });
    $("#validateUpdateUnionUnionDemoInfoForm #createTime3").ECalendar({
        type:"time",
        stamp : false,
        offset:[0,2],
        format:"yyyy-mm-dd hh:ii:ss",
        skin:1,
        step:1,
        callback:function(v,e){revalidateDate("validateUpdateUnionUnionDemoInfoForm","createTime3");} //回调函数
    });
    $('#queryUnionUnionDemoInfoForm #createDate').dateRangePicker({
        startOfWeek: 'monday',
        separator : ' 至 ',
        format: 'YYYY-MM-DD',
        autoClose: false
    });
    $("#validateAddUnionUnionDemoInfoForm #createDate1").ECalendar({
        type:"date",
        stamp : false,
        offset:[0,2],
        format:"yyyy-mm-dd",
        skin:1,
        callback:function(v,e){revalidateDate("validateAddUnionUnionDemoInfoForm","createDate1");} //回调函数
    });
    $("#validateUpdateUnionUnionDemoInfoForm #createDate3").ECalendar({
        type:"date",
        stamp : false,
        offset:[0,2],
        format:"yyyy-mm-dd",
        skin:1,
        callback:function(v,e){revalidateDate("validateUpdateUnionUnionDemoInfoForm","createDate3");} //回调函数
    });
    $("#queryUnionUnionDemoInfoForm #createTimea").ECalendar({
        type:"time",
        stamp : false,
        offset:[0,2],
        format:"yyyy-mm-dd hh:ii:ss",
        skin:1,
        step:1,
        callback:function(v,e){revalidateDate("queryUnionUnionDemoInfoForm","createTimea");} //回调函数
    });
    $("#validateAddUnionUnionDemoInfoForm #createTimea1").ECalendar({
        type:"time",
        stamp : false,
        offset:[0,2],
        format:"yyyy-mm-dd hh:ii:ss",
        skin:1,
        step:1,
        callback:function(v,e){revalidateDate("validateAddUnionUnionDemoInfoForm","createTimea1");} //回调函数
    });
    $("#validateUpdateUnionUnionDemoInfoForm #createTimea3").ECalendar({
        type:"time",
        stamp : false,
        offset:[0,2],
        format:"yyyy-mm-dd hh:ii:ss",
        skin:1,
        step:1,
        callback:function(v,e){revalidateDate("validateUpdateUnionUnionDemoInfoForm","createTimea3");} //回调函数
    });
    $('#queryUnionUnionDemoInfoForm #createDatea').dateRangePicker({
        startOfWeek: 'monday',
        separator : ' 至 ',
        format: 'YYYY-MM-DD',
        autoClose: false
    });
    $("#validateAddUnionUnionDemoInfoForm #createDatea1").ECalendar({
        type:"date",
        stamp : false,
        offset:[0,2],
        format:"yyyy-mm-dd",
        skin:1,
        callback:function(v,e){revalidateDate("validateAddUnionUnionDemoInfoForm","createDatea1");} //回调函数
    });
    $("#validateUpdateUnionUnionDemoInfoForm #createDatea3").ECalendar({
        type:"date",
        stamp : false,
        offset:[0,2],
        format:"yyyy-mm-dd",
        skin:1,
        callback:function(v,e){revalidateDate("validateUpdateUnionUnionDemoInfoForm","createDatea3");} //回调函数
    });
    $("#queryUnionUnionDemoInfoForm #createTimeb").ECalendar({
        type:"time",
        stamp : false,
        offset:[0,2],
        format:"yyyy-mm-dd hh:ii:ss",
        skin:1,
        step:1,
        callback:function(v,e){revalidateDate("queryUnionUnionDemoInfoForm","createTimeb");} //回调函数
    });
    $("#validateAddUnionUnionDemoInfoForm #createTimeb1").ECalendar({
        type:"time",
        stamp : false,
        offset:[0,2],
        format:"yyyy-mm-dd hh:ii:ss",
        skin:1,
        step:1,
        callback:function(v,e){revalidateDate("validateAddUnionUnionDemoInfoForm","createTimeb1");} //回调函数
    });
    $("#validateUpdateUnionUnionDemoInfoForm #createTimeb3").ECalendar({
        type:"time",
        stamp : false,
        offset:[0,2],
        format:"yyyy-mm-dd hh:ii:ss",
        skin:1,
        step:1,
        callback:function(v,e){revalidateDate("validateUpdateUnionUnionDemoInfoForm","createTimeb3");} //回调函数
    });
    $('#queryUnionUnionDemoInfoForm #createDateb').dateRangePicker({
        startOfWeek: 'monday',
        separator : ' 至 ',
        format: 'YYYY-MM-DD',
        autoClose: false
    });
    $("#validateAddUnionUnionDemoInfoForm #createDateb1").ECalendar({
        type:"date",
        stamp : false,
        offset:[0,2],
        format:"yyyy-mm-dd",
        skin:1,
        callback:function(v,e){revalidateDate("validateAddUnionUnionDemoInfoForm","createDateb1");} //回调函数
    });
    $("#validateUpdateUnionUnionDemoInfoForm #createDateb3").ECalendar({
        type:"date",
        stamp : false,
        offset:[0,2],
        format:"yyyy-mm-dd",
        skin:1,
        callback:function(v,e){revalidateDate("validateUpdateUnionUnionDemoInfoForm","createDateb3");} //回调函数
    });

    //增加联表查询DEMO校验
    $('#validateAddUnionUnionDemoInfoForm').bootstrapValidator({
        fields : {
            demoNm1 : {
                validators : {"notEmpty":{"message":"演示名称不能为空"},"stringLength":{"min":1,"max":100,"message":"演示名称长度不正确"},"regexp":{"regexp":"^[\\\\u4E00-\\\\u9FA5A-Za-z0-9_]+$","message":"演示名称只能是中文、英文、数字与下划线"}}
            }
            ,
            createTime1 : {
                validators : {
                    notEmpty : {
                        message : 'XX信息不能为空'
                    },
                    stringLength : {
                        min : 1,
                        max : 100,
                        message : 'XX信息长度不正确'
                    },
                    regexp : {
                        regexp : "^.+$",
                        message : 'XX信息与要求的格式不符'
                    }
                }
            }
            ,
            demoMoney1 : {
                validators : {"notEmpty":{"message":"演示金额不能为空"},"stringLength":{"min":1,"max":100,"message":"演示金额长度不正确"},"regexp":{"regexp":"^(([1-9][0-9]{0,9})|0)((.[0-9]{1,2})?)$","message":"演示金额格式不符"}}
            }
            ,
            selectStatic1 : {
                validators : {"notEmpty":{"message":"请选择一个静态选择框"}}
            }
            ,
            selectDynamic1 : {
                validators : {"notEmpty":{"message":"请选择一个动态选择框"}}
            }
            ,
            radioStatic1 : {
                validators : {"notEmpty":{"message":"请选择一个静态单选按钮"}}
            }
            ,
            radioDynamic1 : {
                validators : {"notEmpty":{"message":"请选择一个动态单选按钮"}}
            }
            ,
            createDate1 : {
                validators : {
                    notEmpty : {
                        message : 'XX信息不能为空'
                    },
                    stringLength : {
                        min : 1,
                        max : 100,
                        message : 'XX信息长度不正确'
                    },
                    regexp : {
                        regexp : "^.+$",
                        message : 'XX信息与要求的格式不符'
                    }
                }
            }
            ,
            demoNma1 : {
                validators : {"notEmpty":{"message":"演示名称不能为空"},"stringLength":{"min":1,"max":100,"message":"演示名称长度不正确"},"regexp":{"regexp":"^[\\\\u4E00-\\\\u9FA5A-Za-z0-9_]+$","message":"演示名称只能是中文、英文、数字与下划线"}}
            }
            ,
            createTimea1 : {
                validators : {
                    notEmpty : {
                        message : 'XX信息不能为空'
                    },
                    stringLength : {
                        min : 1,
                        max : 100,
                        message : 'XX信息长度不正确'
                    },
                    regexp : {
                        regexp : "^.+$",
                        message : 'XX信息与要求的格式不符'
                    }
                }
            }
            ,
            demoMoneya1 : {
                validators : {"notEmpty":{"message":"演示金额不能为空"},"stringLength":{"min":1,"max":100,"message":"演示金额长度不正确"},"regexp":{"regexp":"^(([1-9][0-9]{0,9})|0)((.[0-9]{1,2})?)$","message":"演示金额格式不符"}}
            }
            ,
            selectStatica1 : {
                validators : {"notEmpty":{"message":"请选择一个静态选择框"}}
            }
            ,
            selectDynamica1 : {
                validators : {"notEmpty":{"message":"请选择一个动态选择框"}}
            }
            ,
            radioStatica1 : {
                validators : {"notEmpty":{"message":"请选择一个静态单选按钮"}}
            }
            ,
            radioDynamica1 : {
                validators : {"notEmpty":{"message":"请选择一个动态单选按钮"}}
            }
            ,
            createDatea1 : {
                validators : {
                    notEmpty : {
                        message : 'XX信息不能为空'
                    },
                    stringLength : {
                        min : 1,
                        max : 100,
                        message : 'XX信息长度不正确'
                    },
                    regexp : {
                        regexp : "^.+$",
                        message : 'XX信息与要求的格式不符'
                    }
                }
            }
            ,
            demoNmb1 : {
                validators : {"notEmpty":{"message":"演示名称不能为空"},"stringLength":{"min":1,"max":100,"message":"演示名称长度不正确"},"regexp":{"regexp":"^[\\\\u4E00-\\\\u9FA5A-Za-z0-9_]+$","message":"演示名称只能是中文、英文、数字与下划线"}}
            }
            ,
            createTimeb1 : {
                validators : {
                    notEmpty : {
                        message : 'XX信息不能为空'
                    },
                    stringLength : {
                        min : 1,
                        max : 100,
                        message : 'XX信息长度不正确'
                    },
                    regexp : {
                        regexp : "^.+$",
                        message : 'XX信息与要求的格式不符'
                    }
                }
            }
            ,
            demoMoneyb1 : {
                validators : {"notEmpty":{"message":"演示金额不能为空"},"stringLength":{"min":1,"max":100,"message":"演示金额长度不正确"},"regexp":{"regexp":"^(([1-9][0-9]{0,9})|0)((.[0-9]{1,2})?)$","message":"演示金额格式不符"}}
            }
            ,
            selectStaticb1 : {
                validators : {"notEmpty":{"message":"请选择一个静态选择框"}}
            }
            ,
            selectDynamicb1 : {
                validators : {"notEmpty":{"message":"请选择一个动态选择框"}}
            }
            ,
            radioStaticb1 : {
                validators : {"notEmpty":{"message":"请选择一个静态单选按钮"}}
            }
            ,
            radioDynamicb1 : {
                validators : {"notEmpty":{"message":"请选择一个动态单选按钮"}}
            }
            ,
            createDateb1 : {
                validators : {
                    notEmpty : {
                        message : 'XX信息不能为空'
                    },
                    stringLength : {
                        min : 1,
                        max : 100,
                        message : 'XX信息长度不正确'
                    },
                    regexp : {
                        regexp : "^.+$",
                        message : 'XX信息与要求的格式不符'
                    }
                }
            }
        }
     }).on('success.form.bv', function(e) {
         e.preventDefault();
         addUnionUnionDemoInfo();
     });

    //修改联表查询DEMO校验
    $('#validateUpdateUnionUnionDemoInfoForm').bootstrapValidator({
        fields : {
            demoNm3 : {
                validators : {"notEmpty":{"message":"演示名称不能为空"},"stringLength":{"min":1,"max":100,"message":"演示名称长度不正确"},"regexp":{"regexp":"^[\\\\u4E00-\\\\u9FA5A-Za-z0-9_]+$","message":"演示名称只能是中文、英文、数字与下划线"}}
            }
            ,
            createTime3 : {
                validators : {
                    notEmpty : {
                        message : 'XX信息不能为空'
                    },
                    stringLength : {
                        min : 1,
                        max : 100,
                        message : 'XX信息长度不正确'
                    },
                    regexp : {
                        regexp : "^.+$",
                        message : 'XX信息与要求的格式不符'
                    }
                }
            }
            ,
            demoMoney3 : {
                validators : {"notEmpty":{"message":"演示金额不能为空"},"stringLength":{"min":1,"max":100,"message":"演示金额长度不正确"},"regexp":{"regexp":"^(([1-9][0-9]{0,9})|0)((.[0-9]{1,2})?)$","message":"演示金额格式不符"}}
            }
            ,
            selectStatic3 : {
                validators : {"notEmpty":{"message":"请选择一个静态选择框"}}
            }
            ,
            selectDynamic3 : {
                validators : {"notEmpty":{"message":"请选择一个动态选择框"}}
            }
            ,
            radioStatic3 : {
                validators : {"notEmpty":{"message":"请选择一个静态单选按钮"}}
            }
            ,
            radioDynamic3 : {
                validators : {"notEmpty":{"message":"请选择一个动态单选按钮"}}
            }
            ,
            createDate3 : {
                validators : {
                    notEmpty : {
                        message : 'XX信息不能为空'
                    },
                    stringLength : {
                        min : 1,
                        max : 100,
                        message : 'XX信息长度不正确'
                    },
                    regexp : {
                        regexp : "^.+$",
                        message : 'XX信息与要求的格式不符'
                    }
                }
            }
            ,
            demoNma3 : {
                validators : {"notEmpty":{"message":"演示名称不能为空"},"stringLength":{"min":1,"max":100,"message":"演示名称长度不正确"},"regexp":{"regexp":"^[\\\\u4E00-\\\\u9FA5A-Za-z0-9_]+$","message":"演示名称只能是中文、英文、数字与下划线"}}
            }
            ,
            createTimea3 : {
                validators : {
                    notEmpty : {
                        message : 'XX信息不能为空'
                    },
                    stringLength : {
                        min : 1,
                        max : 100,
                        message : 'XX信息长度不正确'
                    },
                    regexp : {
                        regexp : "^.+$",
                        message : 'XX信息与要求的格式不符'
                    }
                }
            }
            ,
            demoMoneya3 : {
                validators : {"notEmpty":{"message":"演示金额不能为空"},"stringLength":{"min":1,"max":100,"message":"演示金额长度不正确"},"regexp":{"regexp":"^(([1-9][0-9]{0,9})|0)((.[0-9]{1,2})?)$","message":"演示金额格式不符"}}
            }
            ,
            selectStatica3 : {
                validators : {"notEmpty":{"message":"请选择一个静态选择框"}}
            }
            ,
            selectDynamica3 : {
                validators : {"notEmpty":{"message":"请选择一个动态选择框"}}
            }
            ,
            radioStatica3 : {
                validators : {"notEmpty":{"message":"请选择一个静态单选按钮"}}
            }
            ,
            radioDynamica3 : {
                validators : {"notEmpty":{"message":"请选择一个动态单选按钮"}}
            }
            ,
            createDatea3 : {
                validators : {
                    notEmpty : {
                        message : 'XX信息不能为空'
                    },
                    stringLength : {
                        min : 1,
                        max : 100,
                        message : 'XX信息长度不正确'
                    },
                    regexp : {
                        regexp : "^.+$",
                        message : 'XX信息与要求的格式不符'
                    }
                }
            }
            ,
            demoNmb3 : {
                validators : {"notEmpty":{"message":"演示名称不能为空"},"stringLength":{"min":1,"max":100,"message":"演示名称长度不正确"},"regexp":{"regexp":"^[\\\\u4E00-\\\\u9FA5A-Za-z0-9_]+$","message":"演示名称只能是中文、英文、数字与下划线"}}
            }
            ,
            createTimeb3 : {
                validators : {
                    notEmpty : {
                        message : 'XX信息不能为空'
                    },
                    stringLength : {
                        min : 1,
                        max : 100,
                        message : 'XX信息长度不正确'
                    },
                    regexp : {
                        regexp : "^.+$",
                        message : 'XX信息与要求的格式不符'
                    }
                }
            }
            ,
            demoMoneyb3 : {
                validators : {"notEmpty":{"message":"演示金额不能为空"},"stringLength":{"min":1,"max":100,"message":"演示金额长度不正确"},"regexp":{"regexp":"^(([1-9][0-9]{0,9})|0)((.[0-9]{1,2})?)$","message":"演示金额格式不符"}}
            }
            ,
            selectStaticb3 : {
                validators : {"notEmpty":{"message":"请选择一个静态选择框"}}
            }
            ,
            selectDynamicb3 : {
                validators : {"notEmpty":{"message":"请选择一个动态选择框"}}
            }
            ,
            radioStaticb3 : {
                validators : {"notEmpty":{"message":"请选择一个静态单选按钮"}}
            }
            ,
            radioDynamicb3 : {
                validators : {"notEmpty":{"message":"请选择一个动态单选按钮"}}
            }
            ,
            createDateb3 : {
                validators : {
                    notEmpty : {
                        message : 'XX信息不能为空'
                    },
                    stringLength : {
                        min : 1,
                        max : 100,
                        message : 'XX信息长度不正确'
                    },
                    regexp : {
                        regexp : "^.+$",
                        message : 'XX信息与要求的格式不符'
                    }
                }
            }
        }
     }).on('success.form.bv', function(e) {
         e.preventDefault();
         updateUnionUnionDemoInfo();
     });
    //查询联表查询DEMO校验
    $('#queryUnionUnionDemoInfoForm').bootstrapValidator({
        fields : {
            demoId : {
                validators : {"stringLength":{"min":1,"max":100,"message":"表ID长度不正确"},"regexp":{"regexp":"^[0-9]*$","message":"表ID与要求的格式不符"}}
            }
            ,
            forgienId : {
                validators : {"stringLength":{"min":1,"max":100,"message":"表ID长度不正确"},"regexp":{"regexp":"^[0-9]*$","message":"表ID与要求的格式不符"}}
            }
            ,
            demoNm : {
                validators : {"stringLength":{"min":1,"max":100,"message":"演示名称长度不正确"},"regexp":{"regexp":"^[\\\\u4E00-\\\\u9FA5A-Za-z0-9_]+$","message":"演示名称只能是中文、英文、数字与下划线"}}
            }
            ,
            createTime : {
                validators : {"stringLength":{"min":1,"max":100,"message":"XX信息长度不正确"},"regexp":{"regexp":"^.+$","message":"XX信息与要求的格式不符"}}
            }
            ,
            demoMoney : {
                validators : {"stringLength":{"min":1,"max":100,"message":"演示金额长度不正确"},"regexp":{"regexp":"^(([1-9][0-9]{0,9})|0)((.[0-9]{1,2})?)$","message":"演示金额格式不符"}}
            }
            ,
            selectStatic : {
                validators : {}
            }
            ,
            selectDynamic : {
                validators : {}
            }
            ,
            radioStatic : {
                validators : {}
            }
            ,
            radioDynamic : {
                validators : {}
            }
            ,
            createDate : {
                validators : {"stringLength":{"min":1,"max":100,"message":"XX信息长度不正确"},"regexp":{"regexp":"^([0-9]{4}-[0-9]{2}-[0-9]{2})( )*至( )*([0-9]{4}-[0-9]{2}-[0-9]{2})$","message":"时间格式不正确"}}
            }
            ,
            demoIda : {
                validators : {"stringLength":{"min":1,"max":100,"message":"表ID长度不正确"},"regexp":{"regexp":"^[0-9]*$","message":"表ID与要求的格式不符"}}
            }
            ,
            demoNma : {
                validators : {"stringLength":{"min":1,"max":100,"message":"演示名称长度不正确"},"regexp":{"regexp":"^[\\\\u4E00-\\\\u9FA5A-Za-z0-9_]+$","message":"演示名称只能是中文、英文、数字与下划线"}}
            }
            ,
            createTimea : {
                validators : {"stringLength":{"min":1,"max":100,"message":"XX信息长度不正确"},"regexp":{"regexp":"^.+$","message":"XX信息与要求的格式不符"}}
            }
            ,
            demoMoneya : {
                validators : {"stringLength":{"min":1,"max":100,"message":"演示金额长度不正确"},"regexp":{"regexp":"^(([1-9][0-9]{0,9})|0)((.[0-9]{1,2})?)$","message":"演示金额格式不符"}}
            }
            ,
            selectStatica : {
                validators : {}
            }
            ,
            selectDynamica : {
                validators : {}
            }
            ,
            radioStatica : {
                validators : {}
            }
            ,
            radioDynamica : {
                validators : {}
            }
            ,
            createDatea : {
                validators : {"stringLength":{"min":1,"max":100,"message":"XX信息长度不正确"},"regexp":{"regexp":"^([0-9]{4}-[0-9]{2}-[0-9]{2})( )*至( )*([0-9]{4}-[0-9]{2}-[0-9]{2})$","message":"时间格式不正确"}}
            }
            ,
            demoIdb : {
                validators : {"stringLength":{"min":1,"max":100,"message":"表ID长度不正确"},"regexp":{"regexp":"^[0-9]*$","message":"表ID与要求的格式不符"}}
            }
            ,
            demoNmb : {
                validators : {"stringLength":{"min":1,"max":100,"message":"演示名称长度不正确"},"regexp":{"regexp":"^[\\\\u4E00-\\\\u9FA5A-Za-z0-9_]+$","message":"演示名称只能是中文、英文、数字与下划线"}}
            }
            ,
            createTimeb : {
                validators : {"stringLength":{"min":1,"max":100,"message":"XX信息长度不正确"},"regexp":{"regexp":"^.+$","message":"XX信息与要求的格式不符"}}
            }
            ,
            demoMoneyb : {
                validators : {"stringLength":{"min":1,"max":100,"message":"演示金额长度不正确"},"regexp":{"regexp":"^(([1-9][0-9]{0,9})|0)((.[0-9]{1,2})?)$","message":"演示金额格式不符"}}
            }
            ,
            selectStaticb : {
                validators : {}
            }
            ,
            selectDynamicb : {
                validators : {}
            }
            ,
            radioStaticb : {
                validators : {}
            }
            ,
            radioDynamicb : {
                validators : {}
            }
            ,
            createDateb : {
                validators : {"stringLength":{"min":1,"max":100,"message":"XX信息长度不正确"},"regexp":{"regexp":"^([0-9]{4}-[0-9]{2}-[0-9]{2})( )*至( )*([0-9]{4}-[0-9]{2}-[0-9]{2})$","message":"时间格式不正确"}}
            }
        }
     }).on('success.form.bv', function(e) {
         e.preventDefault();
         console.log("查询校验通过");
     });

});

function searchUnionUnionDemoInfo(currentPage,queryType,fileName,exportParam){
    //没有bootstrapvalidator，则返回
    if($('#queryUnionUnionDemoInfoForm').data('bootstrapValidator')!=null) {
        //对查询框进行校验
        $('#queryUnionUnionDemoInfoForm').data('bootstrapValidator').validate();
        //校验没有通过，则返回
        if(!$('#queryUnionUnionDemoInfoForm').data('bootstrapValidator').isValid()){
            return;
        }
        //----个性化校验示例开始
        //if($('#query"+cleanentityClassName+"Form #被验证组件name').val()=='#'){
        //    layer.alert('XX禁止查询')
        //    //第三个参数为，显示的错误信息所属的validator规则
        //    $('#queryUnionUnionDemoInfoForm').data('bootstrapValidator').updateStatus('被验证组件name','INVALID','stringLength');
        //    return;
        //}
        //----个性化校验示例结束
    }
    var params ={};
    if(currentPage == "undefined" || currentPage =="" || currentPage == null){
        var currentPage_text = $("#queryUnionUnionDemoInfocurrentPage").val();
        if(currentPage_text =="undefined" || currentPage_text =="" || currentPage_text == null){
            currentPage_text = "1";
        }
        params.startIndex = currentPage_text;
    }else{
        params.startIndex = currentPage;
    }

    var pageSize= $("#queryUnionUnionDemoInfopageSize").val();
    if(pageSize=="undefined" || pageSize =="" || pageSize == null){
        params.pageSize = "10";
    }else{
        params.pageSize = pageSize;
    }
    if(queryType!=undefined && queryType =='download'){
        params.queryType='download';
        params.exportParam=exportParam;
        params.fileName=fileName;
    }

    params.demoId = $("#queryUnionUnionDemoInfoForm #demoId").val();
    params.forgienId = $("#queryUnionUnionDemoInfoForm #forgienId").val();
    params.demoNm = $("#queryUnionUnionDemoInfoForm #demoNm").val();
    params.createTime = $("#queryUnionUnionDemoInfoForm #createTime").val();
    params.demoMoney = $("#queryUnionUnionDemoInfoForm #demoMoney").val();
    params.selectStatic = $("#queryUnionUnionDemoInfoForm #selectStatic").val();
    params.selectDynamic = $("#queryUnionUnionDemoInfoForm #selectDynamic").val();
    params.radioStatic = $("#queryUnionUnionDemoInfoForm input[name='radioStatic']:checked").val();
    params.radioDynamic = $("#queryUnionUnionDemoInfoForm input[name='radioDynamic']:checked").val();
    //对于checkbox复选框，作为查询条件默认注释掉，否则将导致数据查询不出。如有需要，请根据需求放开
    //params.checkboxStatic = getCheckBoxVal("queryUnionUnionDemoInfoForm","checkboxStatic");
    //对于checkbox复选框，作为查询条件默认注释掉，否则将导致数据查询不出。如有需要，请根据需求放开
    //params.checkboxDynamic = getCheckBoxVal("queryUnionUnionDemoInfoForm","checkboxDynamic");
    var createDate_regexp = new RegExp('^([0-9]{4}-[0-9]{2}-[0-9]{2})( )*至( )*([0-9]{4}-[0-9]{2}-[0-9]{2})$');
    var createDate_value = $("#queryUnionUnionDemoInfoForm #createDate").val();
    if(createDate_regexp.test(createDate_value)){
        var cs = createDate_regexp.exec(createDate_value);
        params.createDate_start = cs[1]||'';
        params.createDate_end = cs[4]||'';
    }
    
    params.demoIda = $("#queryUnionUnionDemoInfoForm #demoIda").val();
    params.demoNma = $("#queryUnionUnionDemoInfoForm #demoNma").val();
    params.createTimea = $("#queryUnionUnionDemoInfoForm #createTimea").val();
    params.demoMoneya = $("#queryUnionUnionDemoInfoForm #demoMoneya").val();
    params.selectStatica = $("#queryUnionUnionDemoInfoForm #selectStatica").val();
    params.selectDynamica = $("#queryUnionUnionDemoInfoForm #selectDynamica").val();
    params.radioStatica = $("#queryUnionUnionDemoInfoForm input[name='radioStatica']:checked").val();
    params.radioDynamica = $("#queryUnionUnionDemoInfoForm input[name='radioDynamica']:checked").val();
    //对于checkbox复选框，作为查询条件默认注释掉，否则将导致数据查询不出。如有需要，请根据需求放开
    //params.checkboxStatica = getCheckBoxVal("queryUnionUnionDemoInfoForm","checkboxStatica");
    //对于checkbox复选框，作为查询条件默认注释掉，否则将导致数据查询不出。如有需要，请根据需求放开
    //params.checkboxDynamica = getCheckBoxVal("queryUnionUnionDemoInfoForm","checkboxDynamica");
    var createDatea_regexp = new RegExp('^([0-9]{4}-[0-9]{2}-[0-9]{2})( )*至( )*([0-9]{4}-[0-9]{2}-[0-9]{2})$');
    var createDatea_value = $("#queryUnionUnionDemoInfoForm #createDatea").val();
    if(createDatea_regexp.test(createDatea_value)){
        var cs = createDatea_regexp.exec(createDatea_value);
        params.createDatea_start = cs[1]||'';
        params.createDatea_end = cs[4]||'';
    }
    
    params.demoIdb = $("#queryUnionUnionDemoInfoForm #demoIdb").val();
    params.demoNmb = $("#queryUnionUnionDemoInfoForm #demoNmb").val();
    params.createTimeb = $("#queryUnionUnionDemoInfoForm #createTimeb").val();
    params.demoMoneyb = $("#queryUnionUnionDemoInfoForm #demoMoneyb").val();
    params.selectStaticb = $("#queryUnionUnionDemoInfoForm #selectStaticb").val();
    params.selectDynamicb = $("#queryUnionUnionDemoInfoForm #selectDynamicb").val();
    params.radioStaticb = $("#queryUnionUnionDemoInfoForm input[name='radioStaticb']:checked").val();
    params.radioDynamicb = $("#queryUnionUnionDemoInfoForm input[name='radioDynamicb']:checked").val();
    //对于checkbox复选框，作为查询条件默认注释掉，否则将导致数据查询不出。如有需要，请根据需求放开
    //params.checkboxStaticb = getCheckBoxVal("queryUnionUnionDemoInfoForm","checkboxStaticb");
    //对于checkbox复选框，作为查询条件默认注释掉，否则将导致数据查询不出。如有需要，请根据需求放开
    //params.checkboxDynamicb = getCheckBoxVal("queryUnionUnionDemoInfoForm","checkboxDynamicb");
    var createDateb_regexp = new RegExp('^([0-9]{4}-[0-9]{2}-[0-9]{2})( )*至( )*([0-9]{4}-[0-9]{2}-[0-9]{2})$');
    var createDateb_value = $("#queryUnionUnionDemoInfoForm #createDateb").val();
    if(createDateb_regexp.test(createDateb_value)){
        var cs = createDateb_regexp.exec(createDateb_value);
        params.createDateb_start = cs[1]||'';
        params.createDateb_end = cs[4]||'';
    }
    

    var jsonStr = JSON.stringify(params);
    jsonStr = encodeURIComponent(jsonStr);
    jsonStr = encodeURIComponent(jsonStr);
    if(queryType!=undefined && queryType =='download'){
        window.location.href=webUrl+"/unionUnionDemoInfo/search.dhtml?jsonStr="+jsonStr+"&v="+Math.random();
        return;
    }
    
    $.ajax({
        type:"POST",
        url:webUrl+"/unionUnionDemoInfo/search.dhtml",
        timeout:60000,
        dataType:'json',
        data:"jsonStr="+jsonStr,
        success:function(data){
            if(data.code == "success"){
                $("#unionUnionDemoInfoTR_FIRST").siblings().remove();
                var  resultList=data.rows[0].pageRecords;

                //分页
                $("#queryUnionUnionDemoInfocurrentPage").val(data.rows[0].startIndex);
                $("#queryUnionUnionDemoInfototalPage").val(data.rows[0].totalPage);
                $("#queryUnionUnionDemoInfopageSize").val(data.rows[0].pageSize);
                for(var i=0;i<resultList.length;i++){
                    var unionUnionDemoInfoTr = $("<tr class=\"unionUnionDemoInfoTr\"></tr>");
                    $("#unionUnionDemoInfoTR_FIRST").parent().append(unionUnionDemoInfoTr);
                    unionUnionDemoInfoTr.append("<td><input style=\"width:23px;\" type=\"checkbox\"/></td><td>"+(i+1)+"</td>")
                    .append("<td>"+resultList[i].demoNm+"</td>")
                    .append("<td>"+resultList[i].createTime+"</td>")
                    .append("<td>"+resultList[i].countNumber+"</td>")
                    .append("<td>"+resultList[i].demoMoney+"</td>")
                    .append("<td>"+resultList[i].selectStatic_name+"</td>")
                    .append("<td>"+resultList[i].selectDynamic_name+"</td>")
                    .append("<td>"+resultList[i].radioStatic_name+"</td>")
                    .append("<td>"+resultList[i].radioDynamic_name+"</td>")
                    .append("<td>"+resultList[i].checkboxStatic+"</td>")
                    .append("<td>"+resultList[i].checkboxDynamic+"</td>")
                    .append("<td>"+resultList[i].createDate+"</td>")
                    .append("<td>"+resultList[i].demoNma+"</td>")
                    .append("<td>"+resultList[i].createTimea+"</td>")
                    .append("<td>"+resultList[i].countNumbera+"</td>")
                    .append("<td>"+resultList[i].demoMoneya+"</td>")
                    .append("<td>"+resultList[i].selectStatica_name+"</td>")
                    .append("<td>"+resultList[i].selectDynamica_name+"</td>")
                    .append("<td>"+resultList[i].radioStatica_name+"</td>")
                    .append("<td>"+resultList[i].radioDynamica_name+"</td>")
                    .append("<td>"+resultList[i].checkboxStatica+"</td>")
                    .append("<td>"+resultList[i].checkboxDynamica+"</td>")
                    .append("<td>"+resultList[i].createDatea+"</td>")
                    .append("<td>"+resultList[i].demoNmb+"</td>")
                    .append("<td>"+resultList[i].createTimeb+"</td>")
                    .append("<td>"+resultList[i].countNumberb+"</td>")
                    .append("<td>"+resultList[i].demoMoneyb+"</td>")
                    .append("<td>"+resultList[i].selectStaticb_name+"</td>")
                    .append("<td>"+resultList[i].selectDynamicb_name+"</td>")
                    .append("<td>"+resultList[i].radioStaticb_name+"</td>")
                    .append("<td>"+resultList[i].radioDynamicb_name+"</td>")
                    .append("<td>"+resultList[i].checkboxStaticb+"</td>")
                    .append("<td>"+resultList[i].checkboxDynamicb+"</td>")
                    .append("<td>"+resultList[i].createDateb+"</td>")
                    .append("<td class=\"operateTbl\"><button class=\"btn btn-default btn-sm\" onclick=\"return editUnionUnionDemoInfo('"+resultList[i].demoId+"');\"><i class=\"fa fa-edit\"></i></button><button class=\"btn btn-default btn-sm\" onclick=\"return  delUnionUnionDemoInfo('"+resultList[i].demoId+"');\"><i class=\"fa fa-trash-o\"></i></button><button class=\"btn btn-default btn-sm\" onclick=\"return queryUnionUnionDemoInfoObject('"+resultList[i].demoId+"');\"><i class=\"fa fa-search\"></i></button></td>");
                }
                var currentPage = Number($("#queryUnionUnionDemoInfocurrentPage").val());
                var totalPage   = Number($("#queryUnionUnionDemoInfototalPage").val());
                var pageSize    = Number($("#queryUnionUnionDemoInfopageSize").val());
                $("#queryUnionUnionDemoInfo_fy .pager").ucPager({
                    currentPage : currentPage,
                    totalPage : totalPage,
                    pageSize : pageSize,
                    clickCallback: queryUnionUnionDemoInfogopage
                });
            }else{
                layer.alert(data.message);
            }
        },
        error: function(XMLHttpRequest, textStatus, errorThrown){
            layer.alert('系统异常，请稍后重试！');
        },
        complete : function(XMLHttpRequest,status){
            if(status == "timeout"){
                ajaxTimeoutTest.abort();
                layer.alert("操作超时！");
            }
        }
    });
}

function queryUnionUnionDemoInfogopage(currentPage) {
    searchUnionUnionDemoInfo(currentPage);
}

function addUnionUnionDemoInfo(){
    var url=webUrl+"/unionUnionDemoInfo/insert.dhtml";
    var params={};
    params.demoNm = $("#validateAddUnionUnionDemoInfoForm #demoNm1").val();
    params.createTime = $("#validateAddUnionUnionDemoInfoForm #createTime1").val();
    params.demoMoney = $("#validateAddUnionUnionDemoInfoForm #demoMoney1").val();
    params.selectStatic = $("#validateAddUnionUnionDemoInfoForm #selectStatic1").val();
    params.selectDynamic = $("#validateAddUnionUnionDemoInfoForm #selectDynamic1").val();
    params.radioStatic = $("#validateAddUnionUnionDemoInfoForm input[name='radioStatic1']:checked").val();
    params.radioDynamic = $("#validateAddUnionUnionDemoInfoForm input[name='radioDynamic1']:checked").val();
    params.checkboxStatic = getCheckBoxVal("validateAddUnionUnionDemoInfoForm","checkboxStatic1");
    params.checkboxDynamic = getCheckBoxVal("validateAddUnionUnionDemoInfoForm","checkboxDynamic1");
    params.createDate = $("#validateAddUnionUnionDemoInfoForm #createDate1").val();
    params.demoNma = $("#validateAddUnionUnionDemoInfoForm #demoNma1").val();
    params.createTimea = $("#validateAddUnionUnionDemoInfoForm #createTimea1").val();
    params.demoMoneya = $("#validateAddUnionUnionDemoInfoForm #demoMoneya1").val();
    params.selectStatica = $("#validateAddUnionUnionDemoInfoForm #selectStatica1").val();
    params.selectDynamica = $("#validateAddUnionUnionDemoInfoForm #selectDynamica1").val();
    params.radioStatica = $("#validateAddUnionUnionDemoInfoForm input[name='radioStatica1']:checked").val();
    params.radioDynamica = $("#validateAddUnionUnionDemoInfoForm input[name='radioDynamica1']:checked").val();
    params.checkboxStatica = getCheckBoxVal("validateAddUnionUnionDemoInfoForm","checkboxStatica1");
    params.checkboxDynamica = getCheckBoxVal("validateAddUnionUnionDemoInfoForm","checkboxDynamica1");
    params.createDatea = $("#validateAddUnionUnionDemoInfoForm #createDatea1").val();
    params.demoNmb = $("#validateAddUnionUnionDemoInfoForm #demoNmb1").val();
    params.createTimeb = $("#validateAddUnionUnionDemoInfoForm #createTimeb1").val();
    params.demoMoneyb = $("#validateAddUnionUnionDemoInfoForm #demoMoneyb1").val();
    params.selectStaticb = $("#validateAddUnionUnionDemoInfoForm #selectStaticb1").val();
    params.selectDynamicb = $("#validateAddUnionUnionDemoInfoForm #selectDynamicb1").val();
    params.radioStaticb = $("#validateAddUnionUnionDemoInfoForm input[name='radioStaticb1']:checked").val();
    params.radioDynamicb = $("#validateAddUnionUnionDemoInfoForm input[name='radioDynamicb1']:checked").val();
    params.checkboxStaticb = getCheckBoxVal("validateAddUnionUnionDemoInfoForm","checkboxStaticb1");
    params.checkboxDynamicb = getCheckBoxVal("validateAddUnionUnionDemoInfoForm","checkboxDynamicb1");
    params.createDateb = $("#validateAddUnionUnionDemoInfoForm #createDateb1").val();
    //获取子表参数
    var subArray = new Array();
    $.each($("#validateAddUnionUnionDemoInfoForm .sub1_"),function(i,obj){
        var subNum = $(this).attr("subNum");
        var subParams={};
        subParams.demoNmc = $("#validateAddUnionUnionDemoInfoForm #demoNmc1_"+subNum).val();
        subParams.createTimec = $("#validateAddUnionUnionDemoInfoForm #createTimec1_"+subNum).val();
        subParams.demoMoneyc = $("#validateAddUnionUnionDemoInfoForm #demoMoneyc1_"+subNum).val();
        subParams.selectStaticc = $("#validateAddUnionUnionDemoInfoForm #selectStaticc1_"+subNum).val();
        subParams.selectDynamicc = $("#validateAddUnionUnionDemoInfoForm #selectDynamicc1_"+subNum).val();
        subParams.radioStaticc = $("#validateAddUnionUnionDemoInfoForm input[name='radioStaticc1_"+subNum+"']:checked").val();
        subParams.radioDynamicc = $("#validateAddUnionUnionDemoInfoForm input[name='radioDynamicc1_"+subNum+"']:checked").val();
        subParams.checkboxStaticc = getCheckBoxVal("validateAddUnionUnionDemoInfoForm","checkboxStaticc1_"+subNum);
        subParams.checkboxDynamicc = getCheckBoxVal("validateAddUnionUnionDemoInfoForm","checkboxDynamicc1_"+subNum);
        subParams.createDatec = $("#validateAddUnionUnionDemoInfoForm #createDatec1_"+subNum).val();
        subArray[i] = subParams;
    });
    params.subArray = subArray;
    var jsonStr = JSON.stringify(params);
    jsonStr = encodeURIComponent(jsonStr);
    $.ajax({
        type:"POST",
        url:url,
        timeout:60000,
        dataType:'json',
        data:"jsonStr="+jsonStr,
        success:function(data){
            if(data.code == "success"){
                $('#addUnionUnionDemoInfo').modal('hide');
                searchUnionUnionDemoInfo('');
                layer.msg('添加成功', {icon: 1,time: 2000,offset: 'rb' }, function(){});
                $('#validateAddUnionUnionDemoInfoForm').bootstrapValidator('resetForm', true);
                setCheckBoxVal("validateAddUnionUnionDemoInfoForm","checkboxStatic1",'00000000000000000000000000000000');
                setCheckBoxVal("validateAddUnionUnionDemoInfoForm","checkboxDynamic1",'00000000000000000000000000000000');
                setCheckBoxVal("validateAddUnionUnionDemoInfoForm","checkboxStatica1",'00000000000000000000000000000000');
                setCheckBoxVal("validateAddUnionUnionDemoInfoForm","checkboxDynamica1",'00000000000000000000000000000000');
                setCheckBoxVal("validateAddUnionUnionDemoInfoForm","checkboxStaticb1",'00000000000000000000000000000000');
                setCheckBoxVal("validateAddUnionUnionDemoInfoForm","checkboxDynamicb1",'00000000000000000000000000000000');
                $('#validateAddUnionUnionDemoInfoForm #subContent1 div').html('');
            }else{
                layer.alert(data.message);
                $('#validateAddUnionUnionDemoInfoForm  button[type="submit"]').attr('disabled',false);
            }
        },
        error: function(XMLHttpRequest, textStatus, errorThrown){
            layer.alert('系统异常，请稍后重试！');
                $('#validateAddUnionUnionDemoInfoForm  button[type="submit"]').attr('disabled',false);
        },
        complete : function(XMLHttpRequest,status){
            if(status == "timeout"){
                ajaxTimeoutTest.abort();
                alert("操作超时！");
                $('#validateAddUnionUnionDemoInfoForm  button[type="submit"]').attr('disabled',false);
            }
        }
    });
}

function updateUnionUnionDemoInfo(){
    var url=webUrl+"/unionUnionDemoInfo/edit.dhtml";
    var params={};
    params.id_key = $("#validateUpdateUnionUnionDemoInfoForm #id_key").val();
    params.demoId = $("#validateUpdateUnionUnionDemoInfoForm #demoId3").val();
    params.demoNm = $("#validateUpdateUnionUnionDemoInfoForm #demoNm3").val();
    params.createTime = $("#validateUpdateUnionUnionDemoInfoForm #createTime3").val();
    params.demoMoney = $("#validateUpdateUnionUnionDemoInfoForm #demoMoney3").val();
    params.selectStatic = $("#validateUpdateUnionUnionDemoInfoForm #selectStatic3").val();
    params.selectDynamic = $("#validateUpdateUnionUnionDemoInfoForm #selectDynamic3").val();
    params.radioStatic = $("#validateUpdateUnionUnionDemoInfoForm input[name='radioStatic3']:checked").val();
    params.radioDynamic = $("#validateUpdateUnionUnionDemoInfoForm input[name='radioDynamic3']:checked").val();
    params.checkboxStatic = getCheckBoxVal("validateUpdateUnionUnionDemoInfoForm","checkboxStatic3");
    params.checkboxDynamic = getCheckBoxVal("validateUpdateUnionUnionDemoInfoForm","checkboxDynamic3");
    params.createDate = $("#validateUpdateUnionUnionDemoInfoForm #createDate3").val();
    params.demoIda = $("#validateUpdateUnionUnionDemoInfoForm #demoIda3").val();
    params.demoNma = $("#validateUpdateUnionUnionDemoInfoForm #demoNma3").val();
    params.createTimea = $("#validateUpdateUnionUnionDemoInfoForm #createTimea3").val();
    params.demoMoneya = $("#validateUpdateUnionUnionDemoInfoForm #demoMoneya3").val();
    params.selectStatica = $("#validateUpdateUnionUnionDemoInfoForm #selectStatica3").val();
    params.selectDynamica = $("#validateUpdateUnionUnionDemoInfoForm #selectDynamica3").val();
    params.radioStatica = $("#validateUpdateUnionUnionDemoInfoForm input[name='radioStatica3']:checked").val();
    params.radioDynamica = $("#validateUpdateUnionUnionDemoInfoForm input[name='radioDynamica3']:checked").val();
    params.checkboxStatica = getCheckBoxVal("validateUpdateUnionUnionDemoInfoForm","checkboxStatica3");
    params.checkboxDynamica = getCheckBoxVal("validateUpdateUnionUnionDemoInfoForm","checkboxDynamica3");
    params.createDatea = $("#validateUpdateUnionUnionDemoInfoForm #createDatea3").val();
    params.demoIdb = $("#validateUpdateUnionUnionDemoInfoForm #demoIdb3").val();
    params.demoNmb = $("#validateUpdateUnionUnionDemoInfoForm #demoNmb3").val();
    params.createTimeb = $("#validateUpdateUnionUnionDemoInfoForm #createTimeb3").val();
    params.demoMoneyb = $("#validateUpdateUnionUnionDemoInfoForm #demoMoneyb3").val();
    params.selectStaticb = $("#validateUpdateUnionUnionDemoInfoForm #selectStaticb3").val();
    params.selectDynamicb = $("#validateUpdateUnionUnionDemoInfoForm #selectDynamicb3").val();
    params.radioStaticb = $("#validateUpdateUnionUnionDemoInfoForm input[name='radioStaticb3']:checked").val();
    params.radioDynamicb = $("#validateUpdateUnionUnionDemoInfoForm input[name='radioDynamicb3']:checked").val();
    params.checkboxStaticb = getCheckBoxVal("validateUpdateUnionUnionDemoInfoForm","checkboxStaticb3");
    params.checkboxDynamicb = getCheckBoxVal("validateUpdateUnionUnionDemoInfoForm","checkboxDynamicb3");
    params.createDateb = $("#validateUpdateUnionUnionDemoInfoForm #createDateb3").val();
    //获取子表参数
    var subArray = new Array();
    $.each($("#validateUpdateUnionUnionDemoInfoForm .sub3_"),function(i,obj){
        var subNum = $(this).attr("subNum");
        var subParams={};
        subParams.demoNmc = $("#validateUpdateUnionUnionDemoInfoForm #demoNmc3_"+subNum).val();
        subParams.createTimec = $("#validateUpdateUnionUnionDemoInfoForm #createTimec3_"+subNum).val();
        subParams.demoMoneyc = $("#validateUpdateUnionUnionDemoInfoForm #demoMoneyc3_"+subNum).val();
        subParams.selectStaticc = $("#validateUpdateUnionUnionDemoInfoForm #selectStaticc3_"+subNum).val();
        subParams.selectDynamicc = $("#validateUpdateUnionUnionDemoInfoForm #selectDynamicc3_"+subNum).val();
        subParams.radioStaticc = $("#validateUpdateUnionUnionDemoInfoForm input[name='radioStaticc3_"+subNum+"']:checked").val();
        subParams.radioDynamicc = $("#validateUpdateUnionUnionDemoInfoForm input[name='radioDynamicc3_"+subNum+"']:checked").val();
        subParams.checkboxStaticc = getCheckBoxVal("validateUpdateUnionUnionDemoInfoForm","checkboxStaticc3_"+subNum);
        subParams.checkboxDynamicc = getCheckBoxVal("validateUpdateUnionUnionDemoInfoForm","checkboxDynamicc3_"+subNum);
        subParams.createDatec = $("#validateUpdateUnionUnionDemoInfoForm #createDatec3_"+subNum).val();
        subArray[i] = subParams;
    });
    params.subArray = subArray;
    var jsonStr = JSON.stringify(params);
    jsonStr = encodeURIComponent(jsonStr);
    $.ajax({
        type:"POST",
        url:url,
        timeout:60000,
        dataType:'json',
        data:"jsonStr="+jsonStr,
        success:function(data){
            if(data.code == "success"){
                $('#updateUnionUnionDemoInfo').modal('hide');
                searchUnionUnionDemoInfo('');
                layer.msg('修改成功', {icon: 1,time: 2000,offset: 'rb' }, function(){});
                $('#validateUpdateUnionUnionDemoInfoForm').bootstrapValidator('resetForm', true);
                $('#validateUpdateUnionUnionDemoInfoForm #subContent3 div').html('');
            }else{
                layer.alert(data.message);
                $('#validateUpdateUnionUnionDemoInfoForm  button[type="submit"]').attr('disabled',false);
            }
        },
        error: function(XMLHttpRequest, textStatus, errorThrown){
            layer.alert('系统异常，请稍后重试！');
            $('#validateUpdateUnionUnionDemoInfoForm  button[type="submit"]').attr('disabled',false);
        },
        complete : function(XMLHttpRequest,status){
            if(status == "timeout"){
                ajaxTimeoutTest.abort();
                alert("操作超时！");
                $('#validateUpdateUnionUnionDemoInfoForm  button[type="submit"]').attr('disabled',false);
            }
        }
    });
}

function editUnionUnionDemoInfo(id_key){
    var url=webUrl+"/unionUnionDemoInfo/queryObject.dhtml";
    var params={};
    params.id_key = id_key;;
    var jsonStr = JSON.stringify(params);
    jsonStr = encodeURIComponent(jsonStr);
    $.ajax({
        type:"POST",
        url:url,
        timeout:60000,
        dataType:'json',
        data:"jsonStr="+jsonStr,
        success:function(data){
            if(data.code == "success"){
                $('#updateUnionUnionDemoInfo').modal();
                $("#validateUpdateUnionUnionDemoInfoForm #id_key").val(data.rows[0].id_key);
                var objInfo = data.rows[0];
                $("#validateUpdateUnionUnionDemoInfoForm #demoId3").val(objInfo.demoId!=null?objInfo.demoId:'');
                $("#validateUpdateUnionUnionDemoInfoForm #forgienId3").val(objInfo.forgienId!=null?objInfo.forgienId:'');
                $("#validateUpdateUnionUnionDemoInfoForm #demoNm3").val(objInfo.demoNm!=null?objInfo.demoNm:'');
                $("#validateUpdateUnionUnionDemoInfoForm #createTime3").val(objInfo.createTime!=null?objInfo.createTime:'');
                $("#validateUpdateUnionUnionDemoInfoForm #countNumber3").val(objInfo.countNumber!=null?objInfo.countNumber:'');
                $("#validateUpdateUnionUnionDemoInfoForm #demoMoney3").val(objInfo.demoMoney!=null?objInfo.demoMoney:'');
                $("#validateUpdateUnionUnionDemoInfoForm #selectStatic3").val(objInfo.selectStatic!=null?objInfo.selectStatic:'');
                $("#validateUpdateUnionUnionDemoInfoForm #selectDynamic3").val(objInfo.selectDynamic!=null?objInfo.selectDynamic:'');
                //使用原生javascript对radio进行操作，避免浏览器不兼容问题
                $("#validateUpdateUnionUnionDemoInfoForm input[name='radioStatic3'][value='"+(objInfo.radioStatic!=null?objInfo.radioStatic:'')+"']")[0].checked=true;
                //使用原生javascript对radio进行操作，避免浏览器不兼容问题
                $("#validateUpdateUnionUnionDemoInfoForm input[name='radioDynamic3'][value='"+(objInfo.radioDynamic!=null?objInfo.radioDynamic:'')+"']")[0].checked=true;
                setCheckBoxVal("validateUpdateUnionUnionDemoInfoForm","checkboxStatic3",(objInfo.checkboxStatic!=null?objInfo.checkboxStatic:''));
                setCheckBoxVal("validateUpdateUnionUnionDemoInfoForm","checkboxDynamic3",(objInfo.checkboxDynamic!=null?objInfo.checkboxDynamic:''));
                $("#validateUpdateUnionUnionDemoInfoForm #createDate3").val(objInfo.createDate!=null?objInfo.createDate:'');
                $("#validateUpdateUnionUnionDemoInfoForm #demoIda3").val(objInfo.demoIda!=null?objInfo.demoIda:'');
                $("#validateUpdateUnionUnionDemoInfoForm #demoNma3").val(objInfo.demoNma!=null?objInfo.demoNma:'');
                $("#validateUpdateUnionUnionDemoInfoForm #createTimea3").val(objInfo.createTimea!=null?objInfo.createTimea:'');
                $("#validateUpdateUnionUnionDemoInfoForm #countNumbera3").val(objInfo.countNumbera!=null?objInfo.countNumbera:'');
                $("#validateUpdateUnionUnionDemoInfoForm #demoMoneya3").val(objInfo.demoMoneya!=null?objInfo.demoMoneya:'');
                $("#validateUpdateUnionUnionDemoInfoForm #selectStatica3").val(objInfo.selectStatica!=null?objInfo.selectStatica:'');
                $("#validateUpdateUnionUnionDemoInfoForm #selectDynamica3").val(objInfo.selectDynamica!=null?objInfo.selectDynamica:'');
                //使用原生javascript对radio进行操作，避免浏览器不兼容问题
                $("#validateUpdateUnionUnionDemoInfoForm input[name='radioStatica3'][value='"+(objInfo.radioStatica!=null?objInfo.radioStatica:'')+"']")[0].checked=true;
                //使用原生javascript对radio进行操作，避免浏览器不兼容问题
                $("#validateUpdateUnionUnionDemoInfoForm input[name='radioDynamica3'][value='"+(objInfo.radioDynamica!=null?objInfo.radioDynamica:'')+"']")[0].checked=true;
                setCheckBoxVal("validateUpdateUnionUnionDemoInfoForm","checkboxStatica3",(objInfo.checkboxStatica!=null?objInfo.checkboxStatica:''));
                setCheckBoxVal("validateUpdateUnionUnionDemoInfoForm","checkboxDynamica3",(objInfo.checkboxDynamica!=null?objInfo.checkboxDynamica:''));
                $("#validateUpdateUnionUnionDemoInfoForm #createDatea3").val(objInfo.createDatea!=null?objInfo.createDatea:'');
                $("#validateUpdateUnionUnionDemoInfoForm #demoIdb3").val(objInfo.demoIdb!=null?objInfo.demoIdb:'');
                $("#validateUpdateUnionUnionDemoInfoForm #demoNmb3").val(objInfo.demoNmb!=null?objInfo.demoNmb:'');
                $("#validateUpdateUnionUnionDemoInfoForm #createTimeb3").val(objInfo.createTimeb!=null?objInfo.createTimeb:'');
                $("#validateUpdateUnionUnionDemoInfoForm #countNumberb3").val(objInfo.countNumberb!=null?objInfo.countNumberb:'');
                $("#validateUpdateUnionUnionDemoInfoForm #demoMoneyb3").val(objInfo.demoMoneyb!=null?objInfo.demoMoneyb:'');
                $("#validateUpdateUnionUnionDemoInfoForm #selectStaticb3").val(objInfo.selectStaticb!=null?objInfo.selectStaticb:'');
                $("#validateUpdateUnionUnionDemoInfoForm #selectDynamicb3").val(objInfo.selectDynamicb!=null?objInfo.selectDynamicb:'');
                //使用原生javascript对radio进行操作，避免浏览器不兼容问题
                $("#validateUpdateUnionUnionDemoInfoForm input[name='radioStaticb3'][value='"+(objInfo.radioStaticb!=null?objInfo.radioStaticb:'')+"']")[0].checked=true;
                //使用原生javascript对radio进行操作，避免浏览器不兼容问题
                $("#validateUpdateUnionUnionDemoInfoForm input[name='radioDynamicb3'][value='"+(objInfo.radioDynamicb!=null?objInfo.radioDynamicb:'')+"']")[0].checked=true;
                setCheckBoxVal("validateUpdateUnionUnionDemoInfoForm","checkboxStaticb3",(objInfo.checkboxStaticb!=null?objInfo.checkboxStaticb:''));
                setCheckBoxVal("validateUpdateUnionUnionDemoInfoForm","checkboxDynamicb3",(objInfo.checkboxDynamicb!=null?objInfo.checkboxDynamicb:''));
                $("#validateUpdateUnionUnionDemoInfoForm #createDateb3").val(objInfo.createDateb!=null?objInfo.createDateb:'');
                $('#validateUpdateUnionUnionDemoInfoForm #subContent3 div').html('');
                for(var i = 0;i < data.rows[0].pageRecords.length;i++){
                    updateUnionUnionDemoInfoSub();
                    $("#validateUpdateUnionUnionDemoInfoForm #demoIdc3_"+i).val(data.rows[0].pageRecords[i].demoIdc!=null?data.rows[0].pageRecords[i].demoIdc:'');
                    $("#validateUpdateUnionUnionDemoInfoForm #forgienId3_"+i).val(data.rows[0].pageRecords[i].forgienId!=null?data.rows[0].pageRecords[i].forgienId:'');
                    $("#validateUpdateUnionUnionDemoInfoForm #demoNmc3_"+i).val(data.rows[0].pageRecords[i].demoNmc!=null?data.rows[0].pageRecords[i].demoNmc:'');
                    $("#validateUpdateUnionUnionDemoInfoForm #createTimec3_"+i).val(data.rows[0].pageRecords[i].createTimec!=null?data.rows[0].pageRecords[i].createTimec:'');
                    $("#validateUpdateUnionUnionDemoInfoForm #countNumberc3_"+i).val(data.rows[0].pageRecords[i].countNumberc!=null?data.rows[0].pageRecords[i].countNumberc:'');
                    $("#validateUpdateUnionUnionDemoInfoForm #demoMoneyc3_"+i).val(data.rows[0].pageRecords[i].demoMoneyc!=null?data.rows[0].pageRecords[i].demoMoneyc:'');
                    $("#validateUpdateUnionUnionDemoInfoForm #selectStaticc3_"+i).val(data.rows[0].pageRecords[i].selectStaticc!=null?data.rows[0].pageRecords[i].selectStaticc:'');
                    $("#validateUpdateUnionUnionDemoInfoForm #selectDynamicc3_"+i).val(data.rows[0].pageRecords[i].selectDynamicc!=null?data.rows[0].pageRecords[i].selectDynamicc:'');
                    //使用原生javascript对radio进行操作，避免浏览器不兼容问题
                    $("#validateUpdateUnionUnionDemoInfoForm input[name='radioStaticc3_"+i+"'][value='"+(data.rows[0].pageRecords[i].radioStaticc!=null?data.rows[0].pageRecords[i].radioStaticc:'')+"']")[0].checked=true;
                    //使用原生javascript对radio进行操作，避免浏览器不兼容问题
                    $("#validateUpdateUnionUnionDemoInfoForm input[name='radioDynamicc3_"+i+"'][value='"+(data.rows[0].pageRecords[i].radioDynamicc!=null?data.rows[0].pageRecords[i].radioDynamicc:'')+"']")[0].checked=true;
                    setCheckBoxVal("validateUpdateUnionUnionDemoInfoForm","checkboxStaticc3_"+i,(data.rows[0].pageRecords[i].checkboxStaticc!=null?data.rows[0].pageRecords[i].checkboxStaticc:''));
                    setCheckBoxVal("validateUpdateUnionUnionDemoInfoForm","checkboxDynamicc3_"+i,(data.rows[0].pageRecords[i].checkboxDynamicc!=null?data.rows[0].pageRecords[i].checkboxDynamicc:''));
                    $("#validateUpdateUnionUnionDemoInfoForm #createDatec3_"+i).val(data.rows[0].pageRecords[i].createDatec!=null?data.rows[0].pageRecords[i].createDatec:'');
                }
            }else{
                layer.alert(data.message);
            }
        },
        error: function(XMLHttpRequest, textStatus, errorThrown){
            layer.alert('系统异常，请稍后重试！');
        },
        complete : function(XMLHttpRequest,status){
            if(status == "timeout"){
                ajaxTimeoutTest.abort();
                alert("操作超时！");
            }
        }
    });
}

function queryUnionUnionDemoInfoObject(id_key){
    var url=webUrl+"/unionUnionDemoInfo/queryObject.dhtml";
    var params={};
    params.id_key = id_key;;
    var jsonStr = JSON.stringify(params);
    jsonStr = encodeURIComponent(jsonStr);
    $.ajax({
        type:"POST",
        url:url,
        timeout:60000,
        dataType:'json',
        data:"jsonStr="+jsonStr,
        success:function(data){
            if(data.code == "success"){
                $('#detailUnionUnionDemoInfo').modal();
                $("#validateDetailUnionUnionDemoInfoForm #id_key").val(data.rows[0].id_key);
                var objInfo = data.rows[0];
                $("#validateDetailUnionUnionDemoInfoForm #demoId2").val(objInfo.demoId!=null?objInfo.demoId:'');
                $("#validateDetailUnionUnionDemoInfoForm #forgienId2").val(objInfo.forgienId!=null?objInfo.forgienId:'');
                $("#validateDetailUnionUnionDemoInfoForm #demoNm2").val(objInfo.demoNm!=null?objInfo.demoNm:'');
                $("#validateDetailUnionUnionDemoInfoForm #createTime2").val(objInfo.createTime!=null?objInfo.createTime:'');
                $("#validateDetailUnionUnionDemoInfoForm #countNumber2").val(objInfo.countNumber!=null?objInfo.countNumber:'');
                $("#validateDetailUnionUnionDemoInfoForm #demoMoney2").val(objInfo.demoMoney!=null?objInfo.demoMoney:'');
                $("#validateDetailUnionUnionDemoInfoForm #selectStatic2").val(objInfo.selectStatic_name!=null?objInfo.selectStatic_name:'');
                $("#validateDetailUnionUnionDemoInfoForm #selectDynamic2").val(objInfo.selectDynamic_name!=null?objInfo.selectDynamic_name:'');
                $("#validateDetailUnionUnionDemoInfoForm #radioStatic2").val(objInfo.radioStatic_name!=null?objInfo.radioStatic_name:'');
                $("#validateDetailUnionUnionDemoInfoForm #radioDynamic2").val(objInfo.radioDynamic_name!=null?objInfo.radioDynamic_name:'');
                setCheckBoxVal("validateDetailUnionUnionDemoInfoForm","checkboxStatic2",(objInfo.checkboxStatic!=null?objInfo.checkboxStatic:''));
                setCheckBoxVal("validateDetailUnionUnionDemoInfoForm","checkboxDynamic2",(objInfo.checkboxDynamic!=null?objInfo.checkboxDynamic:''));
                $("#validateDetailUnionUnionDemoInfoForm #createDate2").val(objInfo.createDate!=null?objInfo.createDate:'');
                $("#validateDetailUnionUnionDemoInfoForm #demoIda2").val(objInfo.demoIda!=null?objInfo.demoIda:'');
                $("#validateDetailUnionUnionDemoInfoForm #demoNma2").val(objInfo.demoNma!=null?objInfo.demoNma:'');
                $("#validateDetailUnionUnionDemoInfoForm #createTimea2").val(objInfo.createTimea!=null?objInfo.createTimea:'');
                $("#validateDetailUnionUnionDemoInfoForm #countNumbera2").val(objInfo.countNumbera!=null?objInfo.countNumbera:'');
                $("#validateDetailUnionUnionDemoInfoForm #demoMoneya2").val(objInfo.demoMoneya!=null?objInfo.demoMoneya:'');
                $("#validateDetailUnionUnionDemoInfoForm #selectStatica2").val(objInfo.selectStatica_name!=null?objInfo.selectStatica_name:'');
                $("#validateDetailUnionUnionDemoInfoForm #selectDynamica2").val(objInfo.selectDynamica_name!=null?objInfo.selectDynamica_name:'');
                $("#validateDetailUnionUnionDemoInfoForm #radioStatica2").val(objInfo.radioStatica_name!=null?objInfo.radioStatica_name:'');
                $("#validateDetailUnionUnionDemoInfoForm #radioDynamica2").val(objInfo.radioDynamica_name!=null?objInfo.radioDynamica_name:'');
                setCheckBoxVal("validateDetailUnionUnionDemoInfoForm","checkboxStatica2",(objInfo.checkboxStatica!=null?objInfo.checkboxStatica:''));
                setCheckBoxVal("validateDetailUnionUnionDemoInfoForm","checkboxDynamica2",(objInfo.checkboxDynamica!=null?objInfo.checkboxDynamica:''));
                $("#validateDetailUnionUnionDemoInfoForm #createDatea2").val(objInfo.createDatea!=null?objInfo.createDatea:'');
                $("#validateDetailUnionUnionDemoInfoForm #demoIdb2").val(objInfo.demoIdb!=null?objInfo.demoIdb:'');
                $("#validateDetailUnionUnionDemoInfoForm #demoNmb2").val(objInfo.demoNmb!=null?objInfo.demoNmb:'');
                $("#validateDetailUnionUnionDemoInfoForm #createTimeb2").val(objInfo.createTimeb!=null?objInfo.createTimeb:'');
                $("#validateDetailUnionUnionDemoInfoForm #countNumberb2").val(objInfo.countNumberb!=null?objInfo.countNumberb:'');
                $("#validateDetailUnionUnionDemoInfoForm #demoMoneyb2").val(objInfo.demoMoneyb!=null?objInfo.demoMoneyb:'');
                $("#validateDetailUnionUnionDemoInfoForm #selectStaticb2").val(objInfo.selectStaticb_name!=null?objInfo.selectStaticb_name:'');
                $("#validateDetailUnionUnionDemoInfoForm #selectDynamicb2").val(objInfo.selectDynamicb_name!=null?objInfo.selectDynamicb_name:'');
                $("#validateDetailUnionUnionDemoInfoForm #radioStaticb2").val(objInfo.radioStaticb_name!=null?objInfo.radioStaticb_name:'');
                $("#validateDetailUnionUnionDemoInfoForm #radioDynamicb2").val(objInfo.radioDynamicb_name!=null?objInfo.radioDynamicb_name:'');
                setCheckBoxVal("validateDetailUnionUnionDemoInfoForm","checkboxStaticb2",(objInfo.checkboxStaticb!=null?objInfo.checkboxStaticb:''));
                setCheckBoxVal("validateDetailUnionUnionDemoInfoForm","checkboxDynamicb2",(objInfo.checkboxDynamicb!=null?objInfo.checkboxDynamicb:''));
                $("#validateDetailUnionUnionDemoInfoForm #createDateb2").val(objInfo.createDateb!=null?objInfo.createDateb:'');
                $('#validateDetailUnionUnionDemoInfoForm #subContent2 div').html('');
                var  resultList = data.rows[0].pageRecords;
                for(var i = 0;i < resultList.length;i++){
                    detailUnionUnionDemoInfoSub('readonly');
                    var objInfo = resultList[i];
                    $("#validateDetailUnionUnionDemoInfoForm #demoIdc2_"+i).val(objInfo.demoIdc!=null?objInfo.demoIdc:'');
                    $("#validateDetailUnionUnionDemoInfoForm #forgienId2_"+i).val(objInfo.forgienId!=null?objInfo.forgienId:'');
                    $("#validateDetailUnionUnionDemoInfoForm #demoNmc2_"+i).val(objInfo.demoNmc!=null?objInfo.demoNmc:'');
                    $("#validateDetailUnionUnionDemoInfoForm #createTimec2_"+i).val(objInfo.createTimec!=null?objInfo.createTimec:'');
                    $("#validateDetailUnionUnionDemoInfoForm #countNumberc2_"+i).val(objInfo.countNumberc!=null?objInfo.countNumberc:'');
                    $("#validateDetailUnionUnionDemoInfoForm #demoMoneyc2_"+i).val(objInfo.demoMoneyc!=null?objInfo.demoMoneyc:'');
                    $("#validateDetailUnionUnionDemoInfoForm #selectStaticc2_"+i).val(objInfo.selectStaticc_name!=null?objInfo.selectStaticc_name:'');
                    $("#validateDetailUnionUnionDemoInfoForm #selectDynamicc2_"+i).val(objInfo.selectDynamicc_name!=null?objInfo.selectDynamicc_name:'');
                    $("#validateDetailUnionUnionDemoInfoForm #radioStaticc2_"+i).val(objInfo.radioStaticc_name!=null?objInfo.radioStaticc_name:'');
                    $("#validateDetailUnionUnionDemoInfoForm #radioDynamicc2_"+i).val(objInfo.radioDynamicc_name!=null?objInfo.radioDynamicc_name:'');
                    setCheckBoxVal("validateDetailUnionUnionDemoInfoForm","checkboxStaticc2_"+i,(objInfo.checkboxStaticc!=null?objInfo.checkboxStaticc:''));
                    setCheckBoxVal("validateDetailUnionUnionDemoInfoForm","checkboxDynamicc2_"+i,(objInfo.checkboxDynamicc!=null?objInfo.checkboxDynamicc:''));
                    $("#validateDetailUnionUnionDemoInfoForm #createDatec2_"+i).val(objInfo.createDatec!=null?objInfo.createDatec:'');
                }
            }else{
                layer.alert(data.message);
            }
        },
        error: function(XMLHttpRequest, textStatus, errorThrown){
            layer.alert('系统异常，请稍后重试！');
        },
        complete : function(XMLHttpRequest,status){
            if(status == "timeout"){
                ajaxTimeoutTest.abort();
                alert("操作超时！");
            }
        }
    });
}
function delUnionUnionDemoInfo(id_key){
    layer.confirm('是否删除？', {
        btn: ['确定','取消'] //按钮
    }, function(){
        var url=webUrl+"/unionUnionDemoInfo/del.dhtml";
        var params={};
        var currentPage= $("#queryUnionUnionDemoInfocurrentPage").val();
        params.id_key = id_key;;
        var jsonStr = JSON.stringify(params);
        jsonStr = encodeURIComponent(jsonStr);
        $.ajax({
            type:"POST",
            url:url,
            timeout:60000,
            dataType:'json',
            data:"jsonStr="+jsonStr,
            success:function(data){
                if(data.code == "success"){
                    layer.msg('删除成功', {icon: 1,time: 2000,offset: 'rb' }, function(){});
                    searchUnionUnionDemoInfo(currentPage);
                }else{
                    layer.alert(data.message);
                }
            },
            error: function(XMLHttpRequest, textStatus, errorThrown){
                layer.alert('系统异常，请稍后重试！');
            },
            complete : function(XMLHttpRequest,status){
                if(status == "timeout"){
                    ajaxTimeoutTest.abort();
                    alert("操作超时！");
                }
            }
        });
    });
}
function colseSub(fromName,divId){
    $('#' + fromName + ' #' + divId).remove();
}


