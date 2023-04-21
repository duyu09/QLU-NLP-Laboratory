// teamOverviewTitleID
export const teamOverview = {
  titleId: '',
}

// 刷新页面函数
// Path: admin_ui\src\components\teamOverview\teamOverview.js
// teamOverviewTitleID
const refreshPage = () => {
  this.$store.dispatch('teamOverview/fetchTeamOverview', this.teamOverview.titleId).then(r => {
    this.teamOverview = r
  })

}
