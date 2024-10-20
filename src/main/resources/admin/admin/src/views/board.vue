<template>

</template>
<script>
import * as echarts from 'echarts'
//0
//0
import router from '@/router/router-static'
export default {
	data() {
		return {
			line: $template2.back.board.line,
			bar: $template2.back.board.bar,
			pie: $template2.back.board.pie,
			myChart0: null,
			boardDataList: [],
			dates: '',
		};
	},
  mounted(){
    this.init();
  },
  created() {
    this.$nextTick(()=>{
		this.times()
	})
  },
  methods:{
	myChartInterval(type, xAxisData, seriesData, myChart) {
	  this.$nextTick(() => {
	    setInterval(() => {
	      let xAxis = xAxisData.shift()
	      xAxisData.push(xAxis)
	      let series = seriesData.shift()
	      seriesData.push(series)
			
			if (type == 1) {
				myChart.setOption({
				  xAxis: [{
				    data: xAxisData
				  }],
				  series: [{
				    data: seriesData
				  }]
				});
			}
			if (type == 2) {
				myChart.setOption({
				  yAxis: [{
				    data: xAxisData
				  }],
				  series: [{
				    data: seriesData
				  }]
				});
			}
	    }, $template2.back.board.bar.base.interval);
	  })
	},
	wordclouds(wordcloudData,echartsId) {
		let wordcloud = $template2.back.board.wordcloud
		wordcloud = JSON.parse(JSON.stringify(wordcloud), (k, v) => {
		  if(typeof v == 'string' && v.indexOf('function') > -1){
		    return eval("(function(){return "+v+" })()")
		  }
		  return v;
		})
		wordcloud.option.series[0].data=wordcloudData;
		
		this.myChart0 = echarts.init(document.getElementById(echartsId));
		let myChart = this.myChart0
		let img = wordcloud.maskImage
	
		if (img) {
			var maskImage = new Image();
			maskImage.src = img
			maskImage.onload = function() {
				wordcloud.option.series[0].maskImage = maskImage
				myChart.clear()
				myChart.setOption(wordcloud.option)
			}
		} else {
			delete wordcloud.option.series[0].maskImage
			myChart.clear()
			myChart.setOption(wordcloud.option)
		}
	},
    getTimeStrToDay(game_over_timestamp) {
        if (game_over_timestamp == 0)
            return "";
        var date = new Date(parseInt(game_over_timestamp));
        var now = new Date();
        var hours = date.getHours() >= 10 ? date.getHours().toString() : "0" + date.getHours();
        var minutes = date.getMinutes() >= 10 ? date.getMinutes().toString() : "0" + date.getMinutes();
        var seconds = date.getSeconds() >= 10 ? date.getSeconds().toString() : "0" + date.getSeconds();
        let arr = ["日", "一", "二", "三", "四", "五", "六"];
        let d = arr[date.getDay()]
        return date.getFullYear() + "年" + (date.getMonth() + 1) + "月" + date.getDate() + '日' + ' ' + ' ' + '星期' + d  + ' ' + "  " + hours + ":" + minutes + ":" + seconds
    },
	times() {
		setInterval(()=>{
            let date = new Date().getTime()
            this.dates = this.getTimeStrToDay(date)
		}, 1000)
	},
	filterTime(time) {
	  const date = new Date(time)
	  const Y = date.getFullYear()
	  const M = date.getMonth() + 1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1 
	  const D = date.getDate() < 10 ? '0' + date.getDate() : date.getDate()
	  
	  const H = date.getHours() < 10 ? '0' + date.getHours() : date.getHours() // 小时
	  const I = date.getMinutes() < 10 ? '0' + date.getMinutes() : date.getMinutes() // 分钟
	  const S = date.getSeconds() < 10 ? '0' + date.getSeconds() : date.getSeconds() // 秒
	  
	  return `${Y}-${M}-${D} ${H}:${I}:${S}`
	},
    init(){
        if(this.$storage.get('Token')){
        this.$http({
            url: `${this.$storage.get('sessionTable')}/session`,
            method: "get"
        }).then(({ data }) => {
            if (data && data.code != 0) {
            router.push({ name: 'login' })
            }
        });
        }else{
            router.push({ name: 'login' })
        }
    },






























































































































































































































































































  }
};
</script>
<style lang="scss" scoped>
    .cardView {
        display: flex;
        flex-wrap: wrap;
        width: 100%;

        .cards {
            display: flex;
            align-items: center;
            width: 100%;
            margin-bottom: 10px;
            justify-content: center;
            .card {
                width: calc(25% - 20px);
                margin: 0 10px;
                /deep/.el-card__body{
                    padding: 0;
                }
            }
        }
    }
	





</style>
