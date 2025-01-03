<template>
  <div class="home_view">
    <div class="projectTitle">欢迎使用 {{ projectName }}</div>
    <div class="count_list">
      <el-collapse-transition v-if="btnAuth('bushujilu', '首页总数')">
        <el-card
          v-show="countTypeList.closebushujiluCountType"
          class="card_view"
        >
          <template #header>
            <div class="index_card_head">
              <div class="card_head_title">步数记录</div>
              <div class="card_head_right">
                <el-icon
                  @click="countTypeClick('hiddenbushujiluCountType')"
                  class="showIcons"
                  :class="
                    countTypeList.hiddenbushujiluCountType ? 'showIcons1' : ''
                  "
                >
                  <ArrowUpBold />
                </el-icon>
                <el-icon
                  @click="countTypeClick('closebushujiluCountType')"
                  class="closeIcons"
                >
                  <CloseBold />
                </el-icon>
              </div>
            </div>
          </template>
          <el-collapse-transition>
            <div
              class="count_item"
              v-show="countTypeList.hiddenbushujiluCountType"
            >
              <div class="count_title">步数记录总数</div>
              <div class="count_num">{{ bushujiluCount }}</div>
            </div>
          </el-collapse-transition>
        </el-card>
      </el-collapse-transition>
    </div>
    <div class="card_list">
      <el-collapse-transition v-if="btnAuth('bushujilu', '首页统计')">
        <el-card
          v-show="cardTypeList.closebushujiluChartType1"
          class="card_view"
        >
          <template #header>
            <div class="index_card_head">
              <div class="card_head_title">步数记录</div>
              <div class="card_head_right">
                <el-icon
                  @click="cardTypeClick('hiddenbushujiluChartType1')"
                  class="showIcons"
                  :class="
                    cardTypeList.hiddenbushujiluChartType1 ? 'showIcons1' : ''
                  "
                >
                  <ArrowUpBold />
                </el-icon>
                <el-icon
                  @click="cardTypeClick('closebushujiluChartType1')"
                  class="closeIcons"
                >
                  <CloseBold />
                </el-icon>
              </div>
            </div>
          </template>
          <el-collapse-transition>
            <div
              class="card_item"
              v-show="cardTypeList.hiddenbushujiluChartType1"
            >
              <div
                id="bushujilubushuEchart1"
                style="width: 100%; height: 400px"
              ></div>
            </div>
          </el-collapse-transition>
        </el-card>
      </el-collapse-transition>
    </div>
  </div>
</template>

<script setup>
import { inject, nextTick, ref, getCurrentInstance } from 'vue'
const context = getCurrentInstance()?.appContext.config.globalProperties
const projectName = context.$project.projectName
const countTypeList = ref({})
const getCountList = () => {
  countTypeList.value.closebushujiluCountType = true
  countTypeList.value.hiddenbushujiluCountType = true
  if (btnAuth('bushujilu', '首页总数')) {
    getbushujiluCount()
  }
}
const bushujiluCount = ref(0)
const getbushujiluCount = () => {
  context
    ?.$http({
      url: 'bushujilu/count',
      method: 'get',
    })
    .then((res) => {
      bushujiluCount.value = res.data.data
    })
}
const countTypeClick = (e) => {
  countTypeList.value[e] = !countTypeList.value[e]
}
const init = () => {
  getCountList()
  getCardList()
}
//权限验证
const btnAuth = (e, a) => {
  return context?.$toolUtil.isAuth(e, a)
}
let echarts = inject('echarts')
const cardTypeClick = (e) => {
  cardTypeList.value[e] = !cardTypeList.value[e]
  setTimeout(() => {
    getCardList()
  }, 1000)
}
const cardTypeList = ref({
  closebushujiluChartType1: true,
  hiddenbushujiluChartType1: true,
})
const getCardList = () => {
  if (btnAuth('bushujilu', '首页统计')) {
    getbushujiluChart1()
  }
}
const getbushujiluChart1 = () => {
  nextTick(() => {
    var bushuEchart1 = echarts.init(
      document.getElementById('bushujilubushuEchart1'),
      'macarons'
    )
    context
      ?.$http({
        url: `bushujilu/value/riqi/bushu`,
        method: 'get',
      })
      .then((obj) => {
        let res = obj.data.data
        let xAxis = []
        let yAxis = []
        let pArray = []
        for (let i = 0; i < res.length; i++) {
          xAxis.push(res[i].riqi)
          yAxis.push(parseFloat(res[i].total))
          pArray.push({
            value: parseFloat(res[i].total),
            name: res[i].riqi,
          })
        }
        var option = {}
        option = {
          title: {
            text: '步数统计',
            left: 'center',
          },
          tooltip: {
            trigger: 'item',
            formatter: '{b} : {c}',
          },
          xAxis: {
            type: 'category',
            data: xAxis,
            axisLabel: {
              rotate: 40,
            },
          },
          yAxis: {
            type: 'value',
          },
          series: [
            {
              data: yAxis,
              type: 'bar',
            },
          ],
        }
        bushuEchart1.clear()
        // 使用刚指定的配置项和数据显示图表。
        bushuEchart1.setOption(option)
        //根据窗口的大小变动图表
        bushuEchart1.resize()
      })
  })
}
init()
</script>
<style lang="scss">
.projectTitle {
  padding: 20px 0;
  margin: 20px 0 20px;
  font-weight: bold;
  display: flex;
  width: 100%;
  font-size: 24px;
  justify-content: center;
  align-items: center;
  height: auto;
}

.showIcons {
  transition: transform 0.3s;
  margin-right: 10px;
}

.showIcons1 {
  transform: rotate(-180deg);
}

// 总数盒子
.count_list {
  padding: 0 0 20px;
  display: flex;
  width: 100%;
  justify-content: center;
  align-items: flex-start;
  flex-wrap: wrap;
  // 总数card
  .card_view {
    border: 1px solid #19a97b30;
    border-radius: 0;
    box-shadow: 0px 0px 0px rgba(0, 0, 0, 0.12);
    margin: 0 1% 20px;
    width: 48%;
    box-sizing: border-box;
    height: auto;
    // card头部
    .el-card__header {
      border: 0px solid #19a97b30;
      background: #19a97b10;
      width: 100%;
      border-width: 0 0 1px;
      // 头部盒子
      .index_card_head {
        display: flex;
        width: 100%;
        justify-content: space-between;
        align-items: center;
        height: 10px;
        // 标题
        .card_head_title {
          color: #666;
          font-size: 14px;
        }
        // 按钮盒子
        .card_head_right {
          display: flex;
          align-items: center;
          // 按钮
          .el-icon {
            cursor: pointer;
            color: #aaa;
            font-size: 20px;
          }
        }
      }
    }
    // body
    .el-card__body {
      padding: 0;
      // body盒子
      .count_item {
        padding: 30px;
        text-align: center;
        // 总数标题
        .count_title {
          color: #333;
          font-size: 16px;
          line-height: 2;
        }
        // 总数数字
        .count_num {
          color: #c00;
          font-size: 30px;
          line-height: 2;
        }
      }
    }
  }
}
// 首页盒子
.home_view {
  padding: 0px 20px;
  margin: 0;
  background: url(http://localhost:8080/sportsRecord/file/09a98f4852104a599055d47953ef0a23.png)
    no-repeat center top / 100% 100% !important;
  width: 100%;
  min-height: 100vh;
  height: auto;
}
// 统计图盒子
.card_list {
  padding: 0 0 20px;
  display: flex;
  width: 100%;
  justify-content: space-between;
  align-items: flex-start;
  flex-wrap: wrap;
  // 统计图card
  .card_view {
    border: 1px solid #19a97b30;
    border-radius: 0;
    box-shadow: 0px 0px 0px rgba(0, 0, 0, 0.12);
    margin: 0 1% 30px;
    width: 100%;
    box-sizing: border-box;
    height: auto;
    // 头部
    .el-card__header {
      border: 0px solid #19a97b30;
      background: #19a97b10;
      width: 100%;
      border-width: 0 0 1px;
      // 头部盒子
      .index_card_head {
        display: flex;
        width: 100%;
        justify-content: space-between;
        align-items: center;
        height: 10px;
        // 标题
        .card_head_title {
          color: #f00;
          font-size: 14px;
        }
        // 按钮盒子
        .card_head_right {
          display: flex;
          align-items: center;
          // 按钮
          .el-icon {
            cursor: pointer;
            color: #aaa;
            font-size: 20px;
          }
        }
      }
    }
    // body
    .el-card__body {
      padding: 0;
      // body盒子
      .card_item {
        padding: 30px;
        text-align: center;
      }
    }
  }
}
</style>
