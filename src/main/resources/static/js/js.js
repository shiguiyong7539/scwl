 $(window).load(function(){$(".loading").fadeOut()})  
$(function () {
    //echarts_1();
    echarts_4();
    echarts_5(1);
    echarts_31();
    //echarts_32('月');
    echarts_33('月');
    getTaskTable();
    getContractTable();
    getRiskTable();
function echarts_1() {
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('echart1'));
        var data = [{
        title: '**省'
    },
    ['本周'],
    [{
        name: '文本1',
        max: 150
    }, {
        name: '文本2',
        max: 150
    }, {
        name: '文本3',
        max: 150
    }, {
        name: '文本4',
        max: 150
    }, {
        name: '文本5',
        max: 150
    }],
    [43, 100, 28, 3, 150],
]
option = {

    color: ['#9DD060', '#35C96E', '#4DCEF8'],

    tooltip: {},
  
    radar: {
        center: ['50%', '50%'],
	 radius: ["25%", "70%"],
		
        name: {
            textStyle: {
                color: '#72ACD1'
            }
        },

          splitLine: {

              lineStyle: {

                  color: 'rgba(255,255,255,.0',

                  width: 2

              }

          },
          axisLine: {
              lineStyle: {
                  color: 'rgba(255,255,255,0.2)',
                  width: 1,
                  type: 'dotted'

              },

          },
        splitArea: {
            areaStyle: {
                  color: ['rgba(255,255,255,.1)', 'rgba(255,255,255,0)']
              }
        },
        indicator: data[2]
    },
    series: [{
        name: '',
        type: 'radar',
        data: [{
                areaStyle: {
                    normal: {
                        opacity: 0.3,
                    }
                },
                value: data[3],
                name: data[1][0]
            },
            {
                areaStyle: {
                    normal: {
                        opacity: 0.3,
                    }
                },
                value: data[4],
                name: data[1][1]
            },
            {
                areaStyle: {
                    normal: {
                        opacity: 0.3,
                    }
                },
                value: data[5],
                name: data[1][2]
            }
        ]
    }]
};
        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
        window.addEventListener("resize",function(){
            myChart.resize();
        });
    }
function echarts_4() {
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('asset_1'));
        var myChart2 = echarts.init(document.getElementById('asset_2'));
        var myChart3 = echarts.init(document.getElementById('asset_3'));
        var myChart4 = echarts.init(document.getElementById('asset_4'));
        myChart4.clear();
    $.ajax({
        type: "get",
        url: "/getManageStateByCenter",
        headers: {
            'Authorization': localStorage.getItem("token") // 在请求头中添加token
        },
        success: function (res) {
            if(res && res.code===200){
                //租金总收入
                document.getElementById("rent_total").innerText = res.obj.rent_total;
                //租金总欠收
                document.getElementById("arrears_now").innerText = res.obj.arrears_now;

                //经营业务总收入
                document.getElementById("in_total").innerText = res.obj.in_total;
                   var manage_date =[];
                   var income_data =[];
                   var income_date =[];
                   var arrears_date =[];
                   var arrears_data =[];
                   var rate_date =[];
                   var rate_data =[];
                var manage_date1 =[];
                var manage_date2 =[];
                var manage_date3 =[];
                var manage_date4 =[];
                var manage_date5 =[];
                var income_data1 =[];
                var income_data2 =[];
                var income_data3 =[];
                var income_data4 =[];
                var income_data5 =[];
                var title_data=[];

                for (let i = 0; i < res.obj.list.length; i++) {
                    var manage = res.obj.list[i].manage;
                        title_data.push(manage[0].name);
                    if(manage[0].name==='旧日长轨'){
                        for (let i = 0; i < manage.length; i++) {
                            manage_date1.push(manage[i].remark+'月');
                            income_data1.push(manage[i].rentIncome);
                        }
                    }
                    if(manage[0].name==='星河集市'){
                        for (let i = 0; i < manage.length; i++) {
                            manage_date2.push(manage[i].remark+'月');
                            income_data2.push(manage[i].rentIncome);
                        }
                    }
                    if(manage[0].name==='金沙艺术中心'){
                        for (let i = 0; i < manage.length; i++) {
                            manage_date3.push(manage[i].remark+'月');
                            income_data3.push(manage[i].rentIncome);
                        }
                    }
                    if(manage[0].name==='灿若湖民宿'){
                        for (let i = 0; i < manage.length; i++) {
                            manage_date4.push(manage[i].remark+'月');
                            income_data4.push(manage[i].rentIncome);
                        }
                    }
                    if(manage[0].name==='活动策划'){
                        for (let i = 0; i < manage.length; i++) {
                            manage_date5.push(manage[i].remark+'月');
                            income_data5.push(manage[i].rentIncome);
                        }
                    }



                }

                for (let i = 0; i < res.obj.income.length; i++) {
                    income_date.push(res.obj.income[i].remark+'月');
                    income_data.push(res.obj.income[i].rentIncome);
                }

                for (let i = 0; i < res.obj.arrears.length; i++) {
                    arrears_date.push(res.obj.arrears[i].remark+'月');
                    arrears_data.push(res.obj.arrears[i].rentArrears);
                }

                for (let i = 0; i < res.obj.rate.length; i++) {
                    rate_date.push(res.obj.rate[i].remark+'月');
                    rate_data.push(res.obj.rate[i].letRate);
                }




                option = {
                       //  backgroundColor: '#00265f',
                       tooltip: {
                           trigger: 'axis',
                           axisPointer: {
                               type: 'shadow'
                           },
                           formatter: function(params) {
                               var axisValue = params[0].axisValue + '</br>';
                               var seriesName = params[0].seriesName + ':';
                               var unit = params[0].value + ' 元';
                               return axisValue+seriesName+unit;
                           }
                       },
                       toolbox: {
                           show: true,
                           feature: {
                               magicType: {
                                   show: true,
                                   type: ['line', 'bar']
                               }
                           }
                       },
                       legend: {
                           data: ['租金收入'],
                           top:'5%',
                           textStyle: {
                               color: "#fff",
                               fontSize: '10',

                           },

                           itemGap: 5
                       },
                       grid: {
                           left: '1%',
                           top:'40px',
                           right: '1%',
                           bottom: '0',
                           containLabel: true
                       },
                       xAxis: [{
                           type: 'category',
                           data: income_date,
                           axisLine: {
                               show: true,
                               lineStyle: {
                                   color: "rgba(255,255,255,.1)",
                                   width: 1,
                                   type: "solid"
                               },
                           },
                           axisTick: {
                               show: false,
                           },
                           axisLabel:  {
                               interval: 0,
                               // rotate:50,
                               show: true,
                               splitNumber: 5,
                               textStyle: {
                                   color: "rgba(255,255,255,.6)",
                                   fontSize: '10',
                               },
                           },
                       }],
                       yAxis: [{
                           type: 'value',
                           axisLabel: {
                               //formatter: '{value} %'
                               show:true,
                               textStyle: {
                                   color: "rgba(255,255,255,.6)",
                                   fontSize: '10',
                               },
                           },
                           axisTick: {
                               show: false,
                           },
                           axisLine: {
                               show: true,
                               lineStyle: {
                                   color: "rgba(255,255,255,.1	)",
                                   width: 1,
                                   type: "solid"
                               },
                           },
                           splitLine: {
                               lineStyle: {
                                   color: "rgba(255,255,255,.1)",
                               }
                           }
                       }],
                       series: [{
                           name: '租金收入',
                           type: 'line',
                           smooth: true,
                           data:income_data,

                           itemStyle: {
                               normal: {
                                   color:'#2f89cf',
                                   opacity: 1,
                                   barBorderRadius: 5,
                               }
                           }
                       }
                       ]
                   };

                   option2 = {
                       //  backgroundColor: '#00265f',
                       tooltip: {
                           trigger: 'axis',
                           axisPointer: {
                               type: 'shadow'
                           },
                           formatter: function(params) {
                               var axisValue = params[0].axisValue + '</br>';
                               var seriesName = params[0].seriesName + ':';
                               var unit = params[0].value + ' 元';
                               return axisValue+seriesName+unit;
                           }
                       },
                       toolbox: {
                           show: true,
                           feature: {
                               magicType: {
                                   show: true,
                                   type: ['line', 'bar']
                               }
                           }
                       },
                       legend: {
                           data: ['欠缴租金'],
                           top:'5%',
                           textStyle: {
                               color: "#fff",
                               fontSize: '10',

                           },

                           itemGap: 35
                       },
                       grid: {
                           left: '1%',
                           top:'40px',
                           right: '1%',
                           bottom: '0',
                           containLabel: true
                       },
                       xAxis: [{
                           type: 'category',
                           data: arrears_date,
                           axisLine: {
                               show: true,
                               lineStyle: {
                                   color: "rgba(255,255,255,.1)",
                                   width: 1,
                                   type: "solid"
                               },
                           },
                           axisTick: {
                               show: false,
                           },
                           axisLabel:  {
                               interval: 0,
                               // rotate:50,
                               show: true,
                               splitNumber: 5,
                               textStyle: {
                                   color: "rgba(255,255,255,.6)",
                                   fontSize: '10',
                               },
                           },
                       }],
                       yAxis: [{
                           type: 'value',
                           axisLabel: {
                               //formatter: '{value} %'
                               show:true,
                               textStyle: {
                                   color: "rgba(255,255,255,.6)",
                                   fontSize: '10',
                               },
                           },
                           axisTick: {
                               show: false,
                           },
                           axisLine: {
                               show: true,
                               lineStyle: {
                                   color: "rgba(255,255,255,.1	)",
                                   width: 1,
                                   type: "solid"
                               },
                           },
                           splitLine: {
                               lineStyle: {
                                   color: "rgba(255,255,255,.1)",
                               }
                           }
                       }],
                       series: [{
                           name: '欠缴租金',
                           type: 'line',
                           smooth: true,
                           data:arrears_data,

                           itemStyle: {
                               normal: {
                                   color:'#2f89cf',
                                   opacity: 1,
                                   barBorderRadius: 5,
                               }
                           }
                       }
                       ]
                   };

                   option3 = {
                       //  backgroundColor: '#00265f',
                       tooltip: {
                           trigger: 'axis',
                           axisPointer: {
                               type: 'shadow'
                           },
                           formatter: function(params) {

                               var axisValue = params[0].axisValue + '</br>';
                               var seriesName = params[0].seriesName + ':';
                               var unit = params[0].value + '%';
                               return axisValue+seriesName+unit;
                           }
                       },
                       toolbox: {
                         show: true,
                         feature: {
                         magicType: {
                             show: true,
                                type: ['line', 'bar']
                           }
                      }
                         },
                       legend: {
                           data: ['出租率'],
                           top:'5%',
                           textStyle: {
                               color: "#fff",
                               fontSize: '10',

                           },

                           itemGap: 35
                       },
                       grid: {
                           left: '1%',
                           top:'40px',
                           right: '1%',
                           bottom: '0',
                           containLabel: true
                       },
                       xAxis: [{
                           type: 'category',
                           data: rate_date,
                           axisLine: {
                               show: true,
                               lineStyle: {
                                   color: "rgba(255,255,255,.1)",
                                   width: 1,
                                   type: "solid"
                               },
                           },
                           axisTick: {
                               show: false,
                           },
                           axisLabel:  {
                               interval: 0,
                               // rotate:50,
                               show: true,
                               splitNumber: 5,
                               textStyle: {
                                   color: "rgba(255,255,255,.6)",
                                   fontSize: '10',
                               },
                           },
                       }],
                       yAxis: [{
                           type: 'value',
                           axisLabel: {
                               //formatter: '{value} %'
                               show:true,
                               textStyle: {
                                   color: "rgba(255,255,255,.6)",
                                   fontSize: '10',
                               },
                           },
                           axisTick: {
                               show: false,
                           },
                           axisLine: {
                               show: true,
                               lineStyle: {
                                   color: "rgba(255,255,255,.1	)",
                                   width: 1,
                                   type: "solid"
                               },
                           },
                           splitLine: {
                               lineStyle: {
                                   color: "rgba(255,255,255,.1)",
                               }
                           }
                       }],
                       series: [{
                           name: '出租率',
                           type: 'line',
                           smooth: true,
                           data:rate_data,

                           itemStyle: {
                               normal: {
                                   color:'#2f89cf',
                                   opacity: 1,
                                   barBorderRadius: 5,
                               }
                           }
                       }
                       ]
                   };

                   // 使用刚指定的配置项和数据显示图表。
                   option4 = {
                       //  backgroundColor: '#00265f',
                       tooltip: {
                           trigger: 'axis',
                           axisPointer: {
                               type: 'shadow'
                            },
                           formatter: function(params) {
                               var axisValue = params[0].axisValue + '</br>';
                               var result='';
                               params.forEach(function(item) {
                                   result += item.seriesName + ': ' + item.value + ' 元<br>';
                               });
                              return axisValue+result;
                           }
                       },
                       legend: {
                           data:title_data,
                           top:'5%',
                           textStyle: {
                               color: "#fff",
                               fontSize: '10',

                           },

                           itemGap: 35
                       },
                       grid: {
                           left: '0%',
                           top:'40px',
                           right: '0%',
                           bottom: '0',
                           containLabel: true
                       },
                       xAxis: [{
                           type: 'category',
                           data: manage_date2,
                           axisLine: {
                               show: true,
                               lineStyle: {
                                   color: "rgba(255,255,255,.1)",
                                   width: 1,
                                   type: "solid"
                               },
                           },
                           axisTick: {
                               show: false,
                           },
                           axisLabel:  {
                               interval: 0,
                               // rotate:50,
                               show: true,
                               splitNumber: 5,
                               textStyle: {
                                   color: "rgba(255,255,255,.6)",
                                   fontSize: '10',
                               },
                           },
                       }],
                       yAxis: [{
                           type: 'value',
                           axisLabel: {
                               //formatter: '{value} %'
                               show:true,
                               textStyle: {
                                   color: "rgba(255,255,255,.6)",
                                   fontSize: '10',
                               },
                           },
                           axisTick: {
                               show: false,
                           },
                           axisLine: {
                               show: true,
                               lineStyle: {
                                   color: "rgba(255,255,255,.1	)",
                                   width: 1,
                                   type: "solid"
                               },
                           },
                           splitLine: {
                               lineStyle: {
                                   color: "rgba(255,255,255,.1)",
                               }
                           }
                       }],
                       series: [{
                           name: '旧日长轨',
                           type: 'line',
                           smooth: true,
                           data:income_data1,

                           itemStyle: {
                               normal: {
                                   color:'#2f89cf',
                                   opacity: 1,
                                   barBorderRadius: 5,
                               }
                           }
                       },{
                           name: '星河集市',
                           type: 'line',
                           smooth: true,
                           data:income_data2,

                           itemStyle: {
                               normal: {
                                   color:'#cf8427',
                                   opacity: 1,
                                   barBorderRadius: 5,
                               }
                           }
                       }
                           ,{
                               name: '金沙艺术中心',
                               type: 'line',
                               smooth: true,
                               data:income_data3,

                               itemStyle: {
                                   normal: {
                                       color:'#cf3b26',
                                       opacity: 1,
                                       barBorderRadius: 5,
                                   }
                               }
                           }
                           ,{
                               name: '灿若湖民宿',
                               type: 'line',
                               smooth: true,
                               data:income_data4,

                               itemStyle: {
                                   normal: {
                                       color:'#4acf28',
                                       opacity: 1,
                                       barBorderRadius: 5,
                                   }
                               }
                           }
                           ,{
                               name: '活动策划',
                               type: 'line',
                               smooth: true,
                               data:income_data5,

                               itemStyle: {
                                   normal: {
                                       color:'#f7ff2c',
                                       opacity: 1,
                                       barBorderRadius: 5,
                                   }
                               }
                           }
                       ]
                   };
                //当前出租率
                document.getElementById("letRate_now").innerText = rate_data[rate_data.length-1]+'%';
                   myChart.setOption(option);
                   myChart2.setOption(option2);
                   myChart3.setOption(option3);
                   myChart4.setOption(option4);
                   window.addEventListener("resize",function(){
                       myChart.resize();
                       myChart2.resize();
                       myChart3.resize();
                       myChart4.resize();
                   });



            }}})
    }
function echarts_5(rate) {
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('capital_1'));
        var myChart2 = echarts.init(document.getElementById('capital_2'));
     //   var myChart3 = echarts.init(document.getElementById('capital_3'));
        $.ajax({
            type: "get",
            url: "/getCapitalByCenterShow",
            headers: {
                'Authorization': localStorage.getItem("token") // 在请求头中添加token
            },
            data:{
                condition:rate
            },
            success: function (res) {
                if(res && res.code===200){
                   // 融资计划完成率 运营费用节约率 营业收入增长率 营业现金比率 营业成本率 可用资金
                  // finishRate;operatRate; incomeRate;cashRate;costRate; useCapital;addDate;remark;
                    //当前可用资金
                    document.getElementById("use_money").innerText = res.obj.use_money;
                    document.getElementById("unUse_money").innerText = res.obj.unUse_money;
                    var income_date = [];
                    //融资计划完成率
                    var finishRateData = [];
                    var finishRateTagData = [];
                    //运营费用节约率
                    var operatRateData = [];
                    var operatRateTagData = [];
                    //营业收入增长率
                    var incomeRateData = [];
                    var incomeRateTagData = [];
                    //营业现金比率
                    var cashRateData = [];
                    var cashRateTagData = [];
                    //营业成本率
                    var costRateData = [];
                    var costRateTagData = [];
                    //可用资金
                    var useCapitalData = [];
                    //不可用资金
                    var unUseCapitalData = [];
                    //最终显示比率数据
                    var showData = [];
                    //最终显示指标数据
                    var showTagData = [];
                    var quarterly_data = [];
                    //显示title
                    var showTtile = ['融资计划完成率','融资计划完成率指标'];
                    var data = res.obj.list;
                    var incomeRate = res.obj.incomeRate;
                    // for (let i = 0; i < data.length; i++) {
                    //     income_date.push(data[i].remark+'月');
                    //     finishRateData.push(data[i].finishRate);
                    //     finishRateTagData.push(data[i].finishRateTag);
                    //     operatRateData.push(data[i].operatRate);
                    //     operatRateTagData.push(data[i].operatRateTag);
                    //     incomeRateData.push(data[i].incomeRate);
                    //     incomeRateTagData.push(data[i].incomeRateTag);
                    //     cashRateData.push(data[i].cashRate);
                    //     cashRateTagData.push(data[i].cashTagRate);
                    //     costRateData.push(data[i].costRate);
                    //     costRateTagData.push(data[i].costTagRate);
                    //     useCapitalData.push(data[i].useCapital);
                    //     unUseCapitalData.push(data[i].unUseCapital);
                    // }
                    for (let i = 0; i < data.length; i++) {
                        income_date.push(data[i].remark+'月');
                        useCapitalData.push(data[i].useCapital);
                        unUseCapitalData.push(data[i].unUseCapital);
                    }

                    for (let i = 0; i < incomeRate.length; i++) {
                        quarterly_data.push(incomeRate[i].quarterly);
                        if(rate==1){
                            showData.push(incomeRate[i].finishRate);
                            showTagData.push(incomeRate[i].finishRateTag);
                        }else if(rate==2){
                            showTtile = ['运营费用节约率','运营费用节约率指标'];
                            showData.push(incomeRate[i].operatRate);
                            showTagData.push(incomeRate[i].operatRateTag);
                        }else if(rate==3){
                            showTtile = ['营业收入增长率','营业收入增长率指标'];
                            showData.push(incomeRate[i].incomeRate);
                            showTagData.push(incomeRate[i].incomeRateTag);
                        }else if(rate==4){
                            showTtile = ['营业现金比率','营业现金比率指标'];
                            showData.push(incomeRate[i].cashRate);
                            showTagData.push(incomeRate[i].cashRateTag);
                        }else if(rate==5){
                            showTtile = ['营业成本率','营业成本率指标'];
                            showData.push(incomeRate[i].costRate);
                            showTagData.push(incomeRate[i].costRateTag);
                        }

                    }

                    option = {
                        //  backgroundColor: '#00265f',
                        tooltip: {
                            trigger: 'axis',
                            axisPointer: {
                                type: 'shadow'
                            } ,
                            formatter: function(params) {
                                var axisValue = params[0].axisValue + '</br>';
                                var result='';
                                params.forEach(function(item) {
                                    result += item.seriesName + ': ' +item.value+ ' %<br>';
                                });
                                return axisValue+result;
                            }
                        },
                        toolbox: {
                            show: true,
                            feature: {
                                magicType: {
                                    show: true,
                                    type: ['line', 'bar']
                                }
                            }
                        },
                        legend: {
                            data: showTtile,
                            top:'-5px',
                            textStyle: {
                                color: "#fff",
                                fontSize: '10',

                            },

                            itemGap: 5
                        },
                        grid: {
                            left: '1%',
                            top:'40px',
                            right: '1%',
                            bottom: '0',
                            containLabel: true
                        },
                        xAxis: [{
                            type: 'category',
                            data: quarterly_data,
                            axisLine: {
                                show: true,
                                lineStyle: {
                                    color: "rgba(255,255,255,.1)",
                                    width: 1,
                                    type: "solid"
                                },
                            },
                            axisTick: {
                                show: false,
                            },
                            axisLabel:  {
                                interval: 0,
                                // rotate:50,
                                show: true,
                                splitNumber: 5,
                                textStyle: {
                                    color: "rgba(255,255,255,.6)",
                                    fontSize: '10',
                                },
                            },
                        }],
                        yAxis: [{
                            type: 'value',
                            axisLabel: {
                                //formatter: '{value} %'
                                show:true,
                                textStyle: {
                                    color: "rgba(255,255,255,.6)",
                                    fontSize: '10',
                                },
                            },
                            axisTick: {
                                show: false,
                            },
                            axisLine: {
                                show: true,
                                lineStyle: {
                                    color: "rgba(255,255,255,.1	)",
                                    width: 1,
                                    type: "solid"
                                },
                            },
                            splitLine: {
                                lineStyle: {
                                    color: "rgba(255,255,255,.1)",
                                }
                            }
                        }],
                        series: [{
                            name: showTtile[0],
                            type: 'line',
                            smooth: true,
                            data:showData,

                            itemStyle: {
                                normal: {
                                    color:'#2f89cf',
                                    opacity: 1,
                                    barBorderRadius: 5,
                                }
                            }
                        },{
                            name: showTtile[1],
                            type: 'line',
                            smooth: true,
                            data:showTagData,

                            itemStyle: {
                                normal: {
                                    color:'#cf8427',
                                    opacity: 1,
                                    barBorderRadius: 5,
                                }
                            }
                        }
                        ]
                    };

                    option2 = {
                        //  backgroundColor: '#00265f',
                        tooltip: {
                            trigger: 'axis',
                            axisPointer: {
                                type: 'shadow'
                            },
                            formatter: function(params) {
                                var axisValue = params[0].axisValue + '</br>';
                                var result='';
                                params.forEach(function(item) {
                                    result += item.seriesName + ': ' +item.value+ '元</br>';
                                });
                                return axisValue+result;
                            }
                        },
                        toolbox: {
                            show: true,
                            feature: {
                                magicType: {
                                    show: true,
                                    type: ['line', 'bar']
                                }
                               // ,dataView: { readOnly: false }
                            }
                        },
                        legend: {
                            data: ['可用资金','不可用资金'],
                            top:'5%',
                            textStyle: {
                                color: "#fff",
                                fontSize: '10',

                            },

                            itemGap: 35
                        },
                        grid: {
                            left: '1%',
                            top:'40px',
                            right: '1%',
                            bottom: '0',
                            containLabel: true
                        },
                        xAxis: [{
                            type: 'category',
                            data: income_date,
                            axisLine: {
                                show: true,
                                lineStyle: {
                                    color: "rgba(255,255,255,.1)",
                                    width: 1,
                                    type: "solid"
                                },
                            },
                            axisTick: {
                                show: false,
                            },
                            axisLabel:  {
                                interval: 0,
                                // rotate:50,
                                show: true,
                                splitNumber: 5,
                                textStyle: {
                                    color: "rgba(255,255,255,.6)",
                                    fontSize: '10',
                                },
                            },
                        }],
                        yAxis: [{
                            type: 'value',
                            axisLabel: {
                                //formatter: '{value} %'
                                show:true,
                                textStyle: {
                                    color: "rgba(255,255,255,.6)",
                                    fontSize: '10',
                                },
                            },
                            axisTick: {
                                show: false,
                            },
                            axisLine: {
                                show: true,
                                lineStyle: {
                                    color: "rgba(255,255,255,.1	)",
                                    width: 1,
                                    type: "solid"
                                },
                            },
                            splitLine: {
                                lineStyle: {
                                    color: "rgba(255,255,255,.1)",
                                }
                            }
                        }],
                        series: [{
                            name: '可用资金',
                            type: 'bar',
                            smooth: true,
                            data:useCapitalData,

                            itemStyle: {
                                normal: {
                                    color:'#2f89cf',
                                    opacity: 1,
                                    barBorderRadius: 5,
                                }
                            }
                        },
                            {
                                name: '不可用资金',
                                type: 'bar',
                                smooth: true,
                                data:unUseCapitalData,

                                itemStyle: {
                                    normal: {
                                        color:'#2ccf0c',
                                        opacity: 1,
                                        barBorderRadius: 5,
                                    }
                                }
                            }
                        ]
                    };

                    // option3 = {
                    //     //  backgroundColor: '#00265f',
                    //     tooltip: {
                    //         trigger: 'axis',
                    //         axisPointer: {
                    //             type: 'shadow'
                    //         },
                    //         formatter: function(params) {
                    //             var axisValue = params[0].axisValue + '</br>';
                    //             var result='';
                    //             params.forEach(function(item) {
                    //                 result += item.seriesName + ': ' +item.value+ ' %<br>';
                    //             });
                    //             return axisValue+result;
                    //         }
                    //     },
                    //     toolbox: {
                    //         show: true,
                    //         feature: {
                    //             magicType: {
                    //                 show: true,
                    //                 type: ['line', 'bar']
                    //             }
                    //         }
                    //     },
                    //     legend: {
                    //         data: ['营业现金比率','营业成本率'],
                    //         top:'-5px',
                    //         textStyle: {
                    //             color: "#fff",
                    //             fontSize: '10',
                    //
                    //         },
                    //
                    //         itemGap: 5
                    //     },
                    //     grid: {
                    //         left: '1%',
                    //         top:'40px',
                    //         right: '1%',
                    //         bottom: '0',
                    //         containLabel: true
                    //     },
                    //     xAxis: [{
                    //         type: 'category',
                    //         data: income_date,
                    //         axisLine: {
                    //             show: true,
                    //             lineStyle: {
                    //                 color: "rgba(255,255,255,.1)",
                    //                 width: 1,
                    //                 type: "solid"
                    //             },
                    //         },
                    //         axisTick: {
                    //             show: false,
                    //         },
                    //         axisLabel:  {
                    //             interval: 0,
                    //             // rotate:50,
                    //             show: true,
                    //             splitNumber: 5,
                    //             textStyle: {
                    //                 color: "rgba(255,255,255,.6)",
                    //                 fontSize: '10',
                    //             },
                    //         },
                    //     }],
                    //     yAxis: [{
                    //         type: 'value',
                    //         axisLabel: {
                    //             //formatter: '{value} %'
                    //             show:true,
                    //             textStyle: {
                    //                 color: "rgba(255,255,255,.6)",
                    //                 fontSize: '10',
                    //             },
                    //         },
                    //         axisTick: {
                    //             show: false,
                    //         },
                    //         axisLine: {
                    //             show: true,
                    //             lineStyle: {
                    //                 color: "rgba(255,255,255,.1	)",
                    //                 width: 1,
                    //                 type: "solid"
                    //             },
                    //         },
                    //         splitLine: {
                    //             lineStyle: {
                    //                 color: "rgba(255,255,255,.1)",
                    //             }
                    //         }
                    //     }],
                    //     series: [
                    //         {
                    //             name: '营业现金比率',
                    //             type: 'line',
                    //             smooth: true,
                    //             data:cashRateData,
                    //
                    //             itemStyle: {
                    //                 normal: {
                    //                     color:'#4acf28',
                    //                     opacity: 1,
                    //                     barBorderRadius: 5,
                    //                 }
                    //             }
                    //         }
                    //         ,{
                    //             name: '营业成本率',
                    //             type: 'line',
                    //             smooth: true,
                    //             data:costRateData,
                    //
                    //             itemStyle: {
                    //                 normal: {
                    //                     color:'#c12125',
                    //                     opacity: 1,
                    //                     barBorderRadius: 5,
                    //                 }
                    //             }
                    //         }
                    //     ]
                    // };
                    // 使用刚指定的配置项和数据显示图表。
                    myChart.setOption(option2);
                    myChart2.setOption(option);
                   // myChart3.setOption(option3);


                    window.addEventListener("resize",function(){
                        myChart.resize();
                        myChart2.resize();
                    });

                }

            }



        })



    }
function echarts_31() {
        // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('fb01'));
	var myChart2 = echarts.init(document.getElementById('fb02'));
	var myChart3 = echarts.init(document.getElementById('fb03'));
	var myChart4 = echarts.init(document.getElementById('fb04'));
	//var myChart5 = echarts.init(document.getElementById('myd1'));
	// var myChart7 = echarts.init(document.getElementById('sysx'));

    $.ajax({
        type: "get",
        url: "/getByCenter",
        headers: {
            'Authorization': localStorage.getItem("token") // 在请求头中添加token
        },
        success: function (res) {
            if(res && res.code===200){
                var total = res.obj.total;
                var age_list = res.obj.age;
                var edu_list = res.obj.edu;
                var rank_list = res.obj.rank;
                var mode_list = res.obj.mode;
                var ageData = [];
                var ageTitle = [];
                var eduData = [];
                var eduTitle = [];
                var rankData = [];
                var rankTitle = [];
                var modeData = [];
                var modeTitle = [];

                for (let i = 0; i < age_list.length; i++) {

                    ageData.push({name:age_list[i].age_range,value:age_list[i].count});
                    ageTitle.push(age_list[i].age_range);

                }
                for (let i = 0; i < edu_list.length; i++) {
                    eduData.push({name:edu_list[i].education,value:edu_list[i].count});
                    eduTitle.push(edu_list[i].education);

                }
                for (let i = 0; i < rank_list.length; i++) {
                    rankData.push({name:rank_list[i].rank,value:rank_list[i].count});
                    rankTitle.push(rank_list[i].rank);

                }
                for (let i = 0; i < mode_list.length; i++) {
                    modeData.push({name:mode_list[i].employment_mode,value:mode_list[i].count});
                    modeTitle.push(mode_list[i].employment_mode);

                }

                option = {
                    tooltip: {
                        trigger: 'item',
                        formatter: "{a} <br/>{b}: {c} 人({d}%)",
                        position:function(p){   //其中p为当前鼠标的位置
                            return [p[0] + 10, p[1] - 10];
                        }
                    },
                    legend: {
                        orient: 'vertical',
                        top:'25%',
                        right:0,
                        itemWidth: 10,
                        itemHeight: 10,
                        data:ageTitle,
                        textStyle: {
                            color: 'rgba(255,255,255,.5)',
                            fontSize:'10',
                        }
                    },
                    series: [
                        {
                            name:'年龄分布',
                            type:'pie',
                            animation:true,
                            center: ['35%', '50%'],
                            radius: ['40%', '50%'],
                            color: ['#62c98d', '#2f89cf', '#4cb9cf', '#e0c828','#e58c00','#eb295b'],
                            label: {show:false},
                            labelLine: {show:false},
                            data:ageData
                        }
                    ]
                };
                option2 = {
                    tooltip: {
                        trigger: 'item',
                        formatter: "{a} <br/>{b}: {c} 人({d}%)",
                        position:function(p){   //其中p为当前鼠标的位置
                            return [p[0] + 10, p[1] - 10];
                        }
                    },
                    legend: {
                        orient: 'vertical',
                        top:'25%',
                        right:'8%',
                        itemWidth: 10,
                        itemHeight: 10,
                        data:eduTitle,
                        textStyle: {
                            color: 'rgba(255,255,255,.5)',
                            fontSize:'10',
                        }
                    },
                    series: [
                        {
                            name:'学历构成',
                            type:'pie',
                            center: ['40%', '50%'],
                            radius: ['40%', '50%'],
                            color: ['#62c98d', '#2f89cf', '#4cb9cf', '#e0c828','#e58c00','#eb295b'],
                            label: {show:false},
                            labelLine: {show:false},
                            data:eduData
                        }
                    ]
                };
                option3 = {
                    tooltip: {
                        trigger: 'item',
                        formatter: "{a} <br/>{b}: {c} 人({d}%)",
                        position:function(p){   //其中p为当前鼠标的位置
                            return [p[0] + 10, p[1] - 10];
                        }
                    },
                    legend: {
                        orient: 'vertical',
                        top:'center',
                        right:0,
                        itemWidth: 10,
                        itemHeight: 10,
                        data:rankTitle,
                        textStyle: {
                            color: 'rgba(255,255,255,.5)',
                            fontSize:'10',
                        }
                    },
                    series: [
                        {
                            name:'职称',
                            type:'pie',
                            center: ['35%', '50%'],
                            radius: ['40%', '50%'],
                            color: ['#62c98d', '#2f89cf', '#4cb9cf', '#e0c828','#e58c00','#eb295b'],
                            label: {show:false},
                            labelLine: {show:false},
                            data:rankData
                        }
                    ]
                };
                option4 = {
                    tooltip: {
                        trigger: 'item',
                        formatter: "{a} <br/>{b}: {c} 人({d}%)",
                        position:function(p){   //其中p为当前鼠标的位置
                            return [p[0] + 10, p[1] - 10];
                        }
                    },
                    legend: {
                        orient: 'vertical',
                        top:'center',
                        right:'8%',
                        itemWidth: 10,
                        itemHeight: 10,
                        data:modeTitle,
                        textStyle: {
                            color: 'rgba(255,255,255,.5)',
                            fontSize:'10',
                        }
                    },
                    series: [
                        {
                            name:'用工方式',
                            type:'pie',
                            center: ['40%', '50%'],
                            radius: ['40%', '50%'],
                            color: ['#62c98d', '#2f89cf', '#4cb9cf', '#e0c828','#e58c00','#eb295b'],
                            label: {show:false},
                            labelLine: {show:false},
                            data:modeData
                        }
                    ]
                };

                //总人数
                document.getElementById("person_total").innerText = total;
                // 使用刚指定的配置项和数据显示图表。
                myChart.setOption(option);
                myChart2.setOption(option2);
                myChart3.setOption(option3);
                myChart4.setOption(option4);


                // myChart7.setOption(option7);
                window.addEventListener("resize",function(){
                    myChart.resize();
                    myChart2.resize();
                    myChart3.resize();
                    myChart4.resize();

                });


            }

        }



    })



    }
// function echarts_32(period) {
//         // 基于准备好的dom，初始化echarts实例
//         var myChart = echarts.init(document.getElementById('fb05'));
//        $.ajax({
//         type: "get",
//         url: "/getCostManageByCenter",
//         headers: {
//             'Authorization': localStorage.getItem("token") // 在请求头中添加token
//         },
//         data:({
//             period:period,
//             condition:currentDate(1)
//         }),
//         success: function (res) {
//             if(res && res.code===200){
//                 var pieData = []
//                 var total_money=0;
//
//                     pieData.push({name:"工资发放",value:res.obj.payOutWage});
//                     pieData.push({name:"房租",value:res.obj.rent});
//                     pieData.push({name:"水电办公等",value:res.obj.hydropowerOffice});
//                     pieData.push({name:"工会",value:res.obj.laborUnion});
//                     total_money+=res.obj.payOutWage+res.obj.rent+res.obj.hydropowerOffice+res.obj.laborUnion;
//
//
//                     option = {
//                         title: {
//                             zlevel: 0,
//                             text: ['{name|累计成本}', '{value|' + total_money + '}{name|万元}'].join('\n'),
//                             top: '35%',
//                             left: '34%',
//                             textAlign: 'center',
//                             textStyle: {
//                                 rich: {
//                                     value: {
//                                         color: '#cf5a1f',
//                                         fontSize: 15,
//                                         lineHeight: 25,
//                                     },
//                                     name: {
//                                         color: '#909399',
//                                         fontSize: 10,
//                                         lineHeight: 25,
//                                     },
//                                 },
//                             }
//                         },
//                         tooltip: {
//                             trigger: 'item',
//                             formatter: "{a} <br/>{b}: {c} 万元 ({d}%)",
//                             position:function(p){   //其中p为当前鼠标的位置
//                                 return [p[0] + 10, p[1] - 10];
//                             },
//                         },
//                         legend: {
//                             type: 'scroll',
//                             orient: 'vertical',
//                             top:'25%',
//                             right:0,
//                             itemWidth: 10,
//                             itemHeight: 10,
//                             data:['工资发放','房租','水电办公等','工会'],
//                             textStyle: {
//                                 color: 'rgba(255,255,255,.5)',
//                                 fontSize:'10',
//                             },
//                             formatter: function(name) {
//                                 var data = option.series[0].data;
//                                 for (let i = 0; i < data.length; i++) {
//                                     if(name === data[i].name){
//                                         var percent = (data[i].value / total_money * 100).toFixed(2) + '%';
//                                         return name + ': ' +data[i].value+ '万元 (' + percent + ')';
//                                     }
//
//                                 }
//                                 },
//                         },
//                         series: [
//                             {
//                                 name:'成本分布',
//                                 type:'pie',
//                                 center: ['35%', '50%'],
//                                 radius: ['40%', '50%'],
//                                 color: ['#62c98d', '#2f89cf', '#4cb9cf', '#e0c828','#e58c00','#eb295b'],
//                                 // 这里与方法一的label设置的一样
//                                 label: {
//                                     show:false,
//                                     position: 'center',
//                                 },
//                                 data:pieData
//                             }
//                         ]
//                     };
//
//                     // 使用刚指定的配置项和数据显示图表。
//                     myChart.setOption(option);
//
//
//                     window.addEventListener("resize",function(){
//                         myChart.resize();
//                     });
//
//
//                 }
//
//             }
//
//
//
//         })
//
//
//
//     }
function getTaskTable() {

        $.ajax({
            type: "get",
            url: "/getTaskByCenterShow",
            headers: {
                'Authorization': localStorage.getItem("token") // 在请求头中添加token
            },
            success: function (res) {
                if(res && res.code===200){
                    var data = res.obj;
                    // 获取表格元素
                    var str_info='';
                    for (let i = 0; i < data.length; i++) {
                        str_info+='<tr><td>'+data[i].project+'</td>';
                        str_info+='<td><span class="text-w">'+isNull(data[i].totalNum)+'</span></td>';
                        str_info+='<td><span class="text-b">'+isNull(data[i].completed)+'</span></td>';
                        str_info+='<td><span class="text-d">'+isNull(data[i].unfinished)+'</span></td>';
                        str_info+='<td><div class="text-d">'+isNull(data[i].overdue)+'</div></td></tr>';
                    }
                    $("#taskTable").html(str_info);
                }

            }



        })

    }
function getContractTable() {
        $.ajax({
            type: "get",
            url: "/getContractByCenter",
            headers: {
                'Authorization': localStorage.getItem("token") // 在请求头中添加token
            },
            success: function (res) {
                if(res && res.code===200){
                    var data = res.obj;
                    var str_info='';
                    for (let i = 0; i < data.length; i++) {
                        str_info+='<tr><td>'+data[i].department+'</td>';
                        str_info+='<td><span class="text-w">'+isNull(data[i].totalNum)+'</span></td>';
                        str_info+='<td><span class="text-b">'+isNull(data[i].finishNum)+'</span></td>';
                        str_info+='<td><div class="text-d">'+isNull(data[i].unfinishNum)+'</div></td></tr>';
                    }
                    $("#contract_table").html(str_info);
                }

            }



        })

    }
function getRiskTable() {
        $.ajax({
            type: "get",
            url: "/getRiskByCenter",
            headers: {
                'Authorization': localStorage.getItem("token") // 在请求头中添加token
            },
            success: function (res) {
                if(res && res.code===200){
                    var data = res.obj;
                    // 获取表格元素
                    var str_info='';
                    for (let i = 0; i < data.length; i++) {
                        str_info+='<tr><td>'+data[i].name+'</td>';
                        str_info+='<td>'+isNull(data[i].num)+'</td>';
                        str_info+='<td><div class="text-w">'+isNull(data[i].yearNum)+'</div></td></tr>';
                    }
                    $("#risk_table").html(str_info);
                }

            }



        })

    }
function total_manage() {
    var myChart = echarts.init(document.getElementById('asset_4'));
     myChart.clear();
    $.ajax({
        type: "get",
        url: "/getTotalManage",
        headers: {
            'Authorization': localStorage.getItem("token") // 在请求头中添加token
        },
        success: function (res) {
            if(res && res.code===200){
                //经营业务总收入
                var income_data =[];
                var manage_date =[];


                for (let i = 0; i < res.obj.length; i++) {
                            manage_date.push(res.obj[i].remark+'月');
                            income_data.push(res.obj[i].rentIncome);
                }
                option = {
                    //  backgroundColor: '#00265f',
                    tooltip: {
                        trigger: 'axis',
                        axisPointer: {
                            type: 'shadow'
                        },
                        formatter: function(params) {
                            var axisValue = params[0].axisValue + '</br>';
                            var result='';
                            params.forEach(function(item) {
                                result += item.seriesName + ': ' + item.value + ' 元<br>';
                            });
                            return axisValue+result;
                        }
                    },
                    legend: {
                        data: ['总收入'],
                        top:'5%',
                        textStyle: {
                            color: "#fff",
                            fontSize: '10',

                        },

                        itemGap: 35
                    },
                    grid: {
                        left: '0%',
                        top:'40px',
                        right: '0%',
                        bottom: '0',
                        containLabel: true
                    },
                    xAxis: [{
                        type: 'category',
                        data: manage_date,
                        axisLine: {
                            show: true,
                            lineStyle: {
                                color: "rgba(255,255,255,.1)",
                                width: 1,
                                type: "solid"
                            },
                        },
                        axisTick: {
                            show: false,
                        },
                        axisLabel:  {
                            interval: 0,
                            // rotate:50,
                            show: true,
                            splitNumber: 5,
                            textStyle: {
                                color: "rgba(255,255,255,.6)",
                                fontSize: '10',
                            },
                        },
                    }],
                    yAxis: [{
                        type: 'value',
                        axisLabel: {
                            //formatter: '{value} %'
                            show:true,
                            textStyle: {
                                color: "rgba(255,255,255,.6)",
                                fontSize: '10',
                            },
                        },
                        axisTick: {
                            show: false,
                        },
                        axisLine: {
                            show: true,
                            lineStyle: {
                                color: "rgba(255,255,255,.1	)",
                                width: 1,
                                type: "solid"
                            },
                        },
                        splitLine: {
                            lineStyle: {
                                color: "rgba(255,255,255,.1)",
                            }
                        }
                    }],
                    series: [{
                        name: '总收入',
                        type: 'line',
                        smooth: true,
                        data:income_data,

                        itemStyle: {
                            normal: {
                                color:'#2f89cf',
                                opacity: 1,
                                barBorderRadius: 5,
                            }
                        }
                    }
                    ]
                };

                myChart.setOption(option);
                window.addEventListener("resize",function(){
                    myChart.resize();
                });

            }}})

}
    function echarts_33(period) {
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('fb06'));
        var myChart2 = echarts.init(document.getElementById('fb07'));
        var myChart3 = echarts.init(document.getElementById('fb08'));
        $.ajax({
            type: "get",
            url: "/getBudgetByCenter",
            headers: {
                'Authorization': localStorage.getItem("token") // 在请求头中添加token
            },
            data:({
                condition:period
            }),
            success: function (res) {
                if(res && res.code===200){
                    var moneyData;
                    if(period=='月'){
                        moneyData = res.obj.month;
                    }else {
                        moneyData = res.obj.year;
                    }
                    var list = res.obj.list;
                    //月度资金
                    var planTotal=res.obj.planTotal;
                    var planData = [];
                    var planTitle = [];
                    //资金实际使用情况
                    var realData=[];
                    var realTotal=res.obj.realTotal;
                    var realTitle = [];

                    //预算偏差率
                    var rateData=[];
                    var rateData2=[];
                    var rateData3=[];
                    var rateData4=[];
                    var rateData5=[];
                    var rateTime=[];
                    var rateTitle=[];

                    for (let i = 0; i < moneyData.length; i++) {
                        var  budget = moneyData[i];
                        planTitle.push(budget.department);
                        realTitle.push(budget.department);
                        planData.push({name:budget.department,value:budget.monthFunds});
                        realData.push({name:budget.department,value:budget.realFunds});
                    }
                        for (let i = 0; i < list.length; i++) {
                         var budgets  = list[i].budgets;
                        if(budgets[0].department==='综合管理部'){
                            for (let i = 0; i < budgets.length; i++) {
                                rateTime.push(budgets[i].remark+'月');
                                rateData.push(budgets[i].deviationRate);
                            }
                        }else if(budgets[0].department==='市场拓展部'){
                            for (let i = 0; i < budgets.length; i++) {
                                rateData2.push(budgets[i].deviationRate);
                            }
                        }else if(budgets[0].department==='规划建设部'){
                            for (let i = 0; i < budgets.length; i++) {
                                rateData3.push(budgets[i].deviationRate);
                            }
                        }else if(budgets[0].department==='财务融资部'){
                            for (let i = 0; i < budgets.length; i++) {
                                rateData4.push(budgets[i].deviationRate);
                            }

                        }else if(budgets[0].department==='金沙艺术中心'){
                            for (let i = 0; i < budgets.length; i++) {
                                rateData5.push(budgets[i].deviationRate);
                            }
                        }
                        rateTitle.push(budgets[0].department);

                    }

                    option = {
                        title: {
                            zlevel: 0,
                            text: ['{name|计划累计}', '{value|' + planTotal + '}{name|万元}'].join('\n'),
                            top: '28%',
                            left: '34%',
                            textAlign: 'center',
                            textStyle: {
                                rich: {
                                    value: {
                                        color: '#cf5a1f',
                                        fontSize: 15,
                                        lineHeight: 25,
                                    },
                                    name: {
                                        color: '#909399',
                                        fontSize: 10,
                                        lineHeight: 25,
                                    },
                                },
                            }
                        },
                        tooltip: {
                            trigger: 'item',
                            formatter: "{a} <br/>{b}: {c} 万元 ({d}%)",
                            position:function(p){   //其中p为当前鼠标的位置
                                return [p[0] + 10, p[1] - 10];
                            },
                        },
                        legend: {
                            type: 'scroll',
                            orient: 'vertical',
                            top:'25%',
                            right:0,
                            itemWidth: 10,
                            itemHeight: 10,
                            data:planTitle,
                            textStyle: {
                                color: 'rgba(255,255,255,.5)',
                                fontSize:'10',
                            },
                            formatter: function(name) {
                                var data = option.series[0].data;
                                for (let i = 0; i < data.length; i++) {
                                    if(name === data[i].name){
                                        var percent = (data[i].value / planTotal * 100).toFixed(2) + '%';
                                        return name + ': ' +data[i].value+ '万元 (' + percent + ')';
                                    }

                                }
                            },
                        },
                        series: [
                            {
                                name:'月度资金',
                                type:'pie',
                                center: ['35%', '50%'],
                                radius: ['65%', '75%'],
                                color: ['#62c98d', '#2f89cf', '#4cb9cf', '#e0c828','#e58c00','#eb295b'],
                                // 这里与方法一的label设置的一样
                                label: {
                                    show:false,
                                    position: 'center',
                                },
                                data:planData
                            }
                        ]
                    };
                    option2 = {
                        title: {
                            zlevel: 0,
                            text: ['{name|实际累计}', '{value|' + realTotal + '}{name|万元}'].join('\n'),
                            top: '28%',
                            left: '34%',
                            textAlign: 'center',
                            textStyle: {
                                rich: {
                                    value: {
                                        color: '#cf5a1f',
                                        fontSize: 15,
                                        lineHeight: 25,
                                    },
                                    name: {
                                        color: '#909399',
                                        fontSize: 10,
                                        lineHeight: 25,
                                    },
                                },
                            }
                        },
                        tooltip: {
                            trigger: 'item',
                            formatter: "{a} <br/>{b}: {c} 万元 ({d}%)",
                            position:function(p){   //其中p为当前鼠标的位置
                                return [p[0] + 10, p[1] - 10];
                            },
                        },
                        legend: {
                            type: 'scroll',
                            orient: 'vertical',
                            top:'25%',
                            right:0,
                            itemWidth: 10,
                            itemHeight: 10,
                            data:realTitle,
                            textStyle: {
                                color: 'rgba(255,255,255,.5)',
                                fontSize:'10',
                            },
                            formatter: function(name) {
                                var data = option2.series[0].data;
                                for (let i = 0; i < data.length; i++) {
                                    if(name === data[i].name){
                                        var percent = (data[i].value / planTotal * 100).toFixed(2) + '%';
                                        return name + ': ' +data[i].value+ '万元 (' + percent + ')';
                                    }

                                }
                            },
                        },
                        series: [
                            {
                                name:'资金实际使用情况',
                                type:'pie',
                                center: ['35%', '50%'],
                                radius: ['65%', '75%'],
                                color: ['#62c98d', '#2f89cf', '#4cb9cf', '#e0c828','#e58c00','#eb295b'],
                                // 这里与方法一的label设置的一样
                                label: {
                                    show:false,
                                    position: 'center',
                                },
                                data:realData
                            }
                        ]
                    };
                    option3 = {
                        //  backgroundColor: '#00265f',
                        tooltip: {
                            trigger: 'axis',
                            axisPointer: {
                                type: 'shadow'
                            },
                            formatter: function(params) {
                                var axisValue = params[0].axisValue + '</br>';
                                var result='';
                                params.forEach(function(item) {
                                    result += item.seriesName + ': ' + item.value + ' %<br>';
                                });
                                return axisValue+result;
                            }
                        },
                        legend: {
                            data: rateTitle,
                            top:'5%',
                            textStyle: {
                                color: "#fff",
                                fontSize: '10',

                            },

                            itemGap: 5
                        },
                        grid: {
                            left: '0%',
                            top:'40px',
                            right: '0%',
                            bottom: '0',
                            containLabel: true
                        },
                        xAxis: [{
                            type: 'category',
                            data: rateTime,
                            axisLine: {
                                show: true,
                                lineStyle: {
                                    color: "rgba(255,255,255,.1)",
                                    width: 1,
                                    type: "solid"
                                },
                            },
                            axisTick: {
                                show: false,
                            },
                            axisLabel:  {
                                interval: 0,
                                // rotate:50,
                                show: true,
                                splitNumber: 5,
                                textStyle: {
                                    color: "rgba(255,255,255,.6)",
                                    fontSize: '10',
                                },
                            },
                        }],
                        yAxis: [{
                            type: 'value',
                            axisLabel: {
                                //formatter: '{value} %'
                                show:true,
                                textStyle: {
                                    color: "rgba(255,255,255,.6)",
                                    fontSize: '10',
                                },
                            },
                            axisTick: {
                                show: false,
                            },
                            axisLine: {
                                show: true,
                                lineStyle: {
                                    color: "rgba(255,255,255,.1	)",
                                    width: 1,
                                    type: "solid"
                                },
                            },
                            splitLine: {
                                lineStyle: {
                                    color: "rgba(255,255,255,.1)",
                                }
                            }
                        }],
                        series: [{
                            name: '综合管理部',
                            type: 'line',
                            smooth: true,
                            data:rateData,

                            itemStyle: {
                                normal: {
                                    color:'#2f89cf',
                                    opacity: 1,
                                    barBorderRadius: 5,
                                }
                            }
                        },{
                            name: '市场拓展部',
                            type: 'line',
                            smooth: true,
                            data:rateData2,

                            itemStyle: {
                                normal: {
                                    color:'#cf8427',
                                    opacity: 1,
                                    barBorderRadius: 5,
                                }
                            }
                        }
                            ,{
                                name: '规划建设部',
                                type: 'line',
                                smooth: true,
                                data:rateData3,

                                itemStyle: {
                                    normal: {
                                        color:'#cf3b26',
                                        opacity: 1,
                                        barBorderRadius: 5,
                                    }
                                }
                            }
                            ,{
                                name: '财务融资部',
                                type: 'line',
                                smooth: true,
                                data:rateData4,

                                itemStyle: {
                                    normal: {
                                        color:'#4acf28',
                                        opacity: 1,
                                        barBorderRadius: 5,
                                    }
                                }
                            }
                            ,{
                                name: '金沙艺术中心',
                                type: 'line',
                                smooth: true,
                                data:rateData5,

                                itemStyle: {
                                    normal: {
                                        color:'#f7ff2c',
                                        opacity: 1,
                                        barBorderRadius: 5,
                                    }
                                }
                            }
                        ]
                    };
                    // 使用刚指定的配置项和数据显示图表。
                    myChart.setOption(option);
                    myChart2.setOption(option2);
                    myChart3.setOption(option3);


                    window.addEventListener("resize",function(){
                        myChart.resize();
                        myChart2.resize();
                        myChart3.resize();
                    });


                }

            }



        })



    }





//获取年月日
function currentDate(type) {
        var date = new Date(); // 创建Date对象
        // 获取年、月、日、小时、分钟和秒
        var year = date.getFullYear();
        var month = date.getMonth() + 1; // 月份从0开始，所以要加1
        var day = date.getDate();
        var hours = date.getHours();
        var minutes = date.getMinutes();
        var seconds = date.getSeconds();
        // 将日期和时间组件组合成字符串
        var formatteddate = year + '-' + month;
        var formattedTime = year + '-' + month + '-' + day;
        if(type==1){
            return formatteddate;
        }else {
            return year;
        }

    }

    //获取所有包含百分比转化
    function percentage(num) {
        var per = Number(num)*100;
        return per +'%';

    }
    function isNull(number) {
        if(null==number){
            return "";
        }else {
            return number;
        }
    }

    $("#now_month").on("click", function() {
        echarts_33('月');
    })
    $("#now_year").on("click", function() {
        echarts_33('年');
    })
    $("#total_manage").on("click", function() {
        total_manage();
    })
    $("#in_details").on("click", function() {
        echarts_4();
    })
    $("#rate_type").on("change", function() {
        // 在这里编写你的函数逻辑
        var selected = $(this).val();
        echarts_5(selected);
    });






    // $("#asset1").on("click", function() {
    //     // var box_show1 = document.getElementsByClassName("box_show1");
    //     // var box_show2 = document.getElementsByClassName("box_show2");
    //     var box1 = document.getElementById("box_id1");
    //     var box2 = document.getElementById("box_id2");
    //     box1.style.display="block";
    //     box2.style.display="none";
    //         // box_show1[0].style = "display:block"; // 修改为显示
    //         // box_show2[0].style = "display:none"; // 修改为隐藏
    //
    //
    // });
    // $("#asset2").on("click", function() {
    //     var box1 = document.getElementById("box_id1");
    //     var box2 = document.getElementById("box_id2");
    //     box2.style.display="block";
    //     box1.style.display="none";
    //
    // });
})



		
		
		


		









