﻿ $(window).load(function(){$(".loading").fadeOut()})  
$(function () {
    //echarts_1();
    echarts_4();
    echarts_5();
    echarts_31();
    echarts_32();
    getTaskTable();
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
    $.ajax({
        type: "get",
        url: "/getManageStateByCenter",
        headers: {
            'Authorization': localStorage.getItem("token") // 在请求头中添加token
        },
        success: function (res) {
            if(res && res.code===200){
                   var manage_date =[];
                   var income_data =[];
                   var arrears_data =[];
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

                for (let i = 0; i < res.obj.length; i++) {
                    var manage = res.obj[i].manage;
                    if(i==0){
                        for (let i = 0; i < manage.length; i++) {
                            manage_date.push(manage[i].remark);
                            income_data.push(manage[i].rentIncome);
                            arrears_data.push(manage[i].rentArrears);
                            rate_data.push(manage[i].letRate);
                        }
                    }else{


                    if(manage[0].name==='旧日长轨'){
                        for (let i = 0; i < manage.length; i++) {
                            manage_date1.push(manage[i].remark);
                            income_data1.push(manage[i].rentIncome);
                        }
                    }
                    if(manage[0].name==='星河集市'){
                        for (let i = 0; i < manage.length; i++) {
                            manage_date2.push(manage[i].remark);
                            income_data2.push(manage[i].rentIncome);
                        }
                    }
                    if(manage[0].name==='金沙艺术中心'){
                        for (let i = 0; i < manage.length; i++) {
                            manage_date3.push(manage[i].remark);
                            income_data3.push(manage[i].rentIncome);
                        }
                    }
                    if(manage[0].name==='灿若湖民宿'){
                        for (let i = 0; i < manage.length; i++) {
                            manage_date4.push(manage[i].remark);
                            income_data4.push(manage[i].rentIncome);
                        }
                    }
                    if(manage[0].name==='活动策划'){
                        for (let i = 0; i < manage.length; i++) {
                            manage_date5.push(manage[i].remark);
                            income_data5.push(manage[i].rentIncome);
                        }
                    }
                    }


                }
                   option = {
                       //  backgroundColor: '#00265f',
                       tooltip: {
                           trigger: 'axis',
                           axisPointer: {
                               type: 'shadow'
                           }
                       },
                       legend: {
                           data: ['租金收入'],
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
                           }
                       },
                       legend: {
                           data: ['旧日长轨','星河集市','金沙艺术中心','灿若湖民宿','活动策划'],
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
                           data: manage_date1,
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
                                       color:'#0c190c',
                                       opacity: 1,
                                       barBorderRadius: 5,
                                   }
                               }
                           }
                       ]
                   };

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
function echarts_5() {
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('capital_1'));
        var myChart2 = echarts.init(document.getElementById('capital_2'));
        $.ajax({
            type: "get",
            url: "/getCapitalByCenterShow",
            headers: {
                'Authorization': localStorage.getItem("token") // 在请求头中添加token
            },
            success: function (res) {
                if(res && res.code===200){
                    var income_date = [];
                    //按月租赁收入
                    var incomeData1 = [];
                    //每月总收入
                    var incomeData2 = [];
                    var expend_date = [];
                    //合同财务支出
                    var expendData1 = [];
                    //专项债支出
                    var expendData2 = [];
                    //日常报销支出
                    var expendData3 = [];
                    var income = res.obj.income;
                    var expend = res.obj.expend;
                    for (let i = 0; i < income.length; i++) {
                        income_date.push(income[i].remark);
                        incomeData1.push(income[i].income);
                        incomeData2.push(income[i].incomeTotal);
                    }
                    for (let i = 0; i < expend.length; i++) {
                        expend_date.push(expend[i].remark);
                        expendData1.push(expend[i].contractExpend);
                        expendData2.push(expend[i].specialExpend);
                        expendData3.push(expend[i].dailyExpend);
                    }
                    option = {
                        //  backgroundColor: '#00265f',
                        tooltip: {
                            trigger: 'axis',
                            axisPointer: {
                                type: 'shadow'
                            }
                        },
                        legend: {
                            data: ['按月租赁收入','每月总收入'],
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
                            name: '按月租赁收入',
                            type: 'bar',
                            smooth: true,
                            data:incomeData1,

                            itemStyle: {
                                normal: {
                                    color:'#2f89cf',
                                    opacity: 1,
                                    barBorderRadius: 5,
                                }
                            }
                        },{
                            name: '每月总收入',
                            type: 'bar',
                            smooth: true,
                            data:incomeData2,

                            itemStyle: {
                                normal: {
                                    color:'#cf841b',
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
                            }
                        },
                        legend: {
                            data: ['合同财务支出','专项债支出','日常报销支出'],
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
                            data: expend_date,
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
                            name: '合同财务支出',
                            type: 'bar',
                            smooth: true,
                            data:expendData1,

                            itemStyle: {
                                normal: {
                                    color:'#2f89cf',
                                    opacity: 1,
                                    barBorderRadius: 5,
                                }
                            }
                        },{
                            name: '专项债支出',
                            type: 'bar',
                            smooth: true,
                            data:expendData2,

                            itemStyle: {
                                normal: {
                                    color:'#cf7e22',
                                    opacity: 1,
                                    barBorderRadius: 5,
                                }
                            }
                            },{
                            name: '日常报销支出',
                            type: 'bar',
                            smooth: true,
                            data:expendData3,

                            itemStyle: {
                                normal: {
                                    color:'#cf1011',
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


                    window.addEventListener("resize",function(){
                        myChart.resize();
                        myChart2.resize();
                    });
                    window.onresize = function() {
                        updateLegendFontSize();
                    };

                }

            }



        })

    // 定义一个函数来更新图例字体大小
    function updateLegendFontSize() {
        var width = document.getElementById('myChart').offsetWidth;
        var fontSize = width / 11;
        myChart.setOption({
            legend: {
                itemWidth: 10,
                itemHeight: 14,
                textStyle: {
                    fontSize: fontSize + 'px'
                }
            }
        });
    }

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
                var age_list = res.obj.age;
                var edu_list = res.obj.edu;
                var rank_list = res.obj.rank;
                var mode_list = res.obj.mode;
                var ageData = [];
                var eduData = [];
                var rankData = [];
                var modeData = [];

                for (let i = 0; i < age_list.length; i++) {

                    ageData.push({name:age_list[i].age_range,value:age_list[i].count});

                }
                for (let i = 0; i < edu_list.length; i++) {
                    eduData.push({name:edu_list[i].education,value:edu_list[i].count});

                }
                for (let i = 0; i < rank_list.length; i++) {
                    rankData.push({name:rank_list[i].rank,value:rank_list[i].count});

                }
                for (let i = 0; i < mode_list.length; i++) {
                    modeData.push({name:mode_list[i].employment_mode,value:mode_list[i].count});

                }

                option = {
                    tooltip: {
                        trigger: 'item',
                        formatter: "{a} <br/>{b}: {c} ({d}%)",
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
                        data:['20-29岁','30-39岁','40-49岁','50-59岁','60-69岁'],
                        textStyle: {
                            color: 'rgba(255,255,255,.5)',
                            fontSize:'10',
                        }
                    },
                    series: [
                        {
                            name:'年龄分布',
                            type:'pie',
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
                        formatter: "{a} <br/>{b}: {c} ({d}%)",
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
                        data:['博士','硕士','本科','专科'],
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
                        formatter: "{a} <br/>{b}: {c} ({d}%)",
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
                        data:['初级','中级','高级'],
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
                        formatter: "{a} <br/>{b}: {c} ({d}%)",
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
                        data:['正式','外聘'],
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
function echarts_32() {
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('fb05'));
       $.ajax({
        type: "get",
        url: "/getCostManageByCenter",
        headers: {
            'Authorization': localStorage.getItem("token") // 在请求头中添加token
        },
        data:({
            period:'月',
            condition:currentDate(1)
        }),
        success: function (res) {
            if(res && res.code===200){
                var pieData = []
                for (let i = 0; i < res.obj.length; i++) {
                    pieData.push({name:"工资发放",value:res.obj[i].payOutWage});
                    pieData.push({name:"房租",value:res.obj[i].rent});
                    pieData.push({name:"水电办公等",value:res.obj[i].hydropowerOffice});
                    pieData.push({name:"工会",value:res.obj[i].laborUnion});
                }

                    option = {
                        tooltip: {
                            trigger: 'item',
                            formatter: "{a} <br/>{b}: {c} ({d}%)",
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
                            data:['工资发放','房租','水电办公等','工会'],
                            textStyle: {
                                color: 'rgba(255,255,255,.5)',
                                fontSize:'10',
                            }
                        },
                        series: [
                            {
                                name:'成本分布',
                                type:'pie',
                                center: ['35%', '50%'],
                                radius: ['40%', '50%'],
                                color: ['#62c98d', '#2f89cf', '#4cb9cf', '#e0c828','#e58c00','#eb295b'],
                                label: {show:false},
                                labelLine: {show:false},
                                data:pieData
                            }
                        ]
                    };

                    // 使用刚指定的配置项和数据显示图表。
                    myChart.setOption(option);


                    window.addEventListener("resize",function(){
                        myChart.resize();
                    });


                }

            }



        })



    }
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



		
		
		


		









