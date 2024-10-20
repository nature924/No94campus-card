const base = {
    get() {
        return {
            url : "http://localhost:8080/springbootq7e7o/",
            name: "springbootq7e7o",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springbootq7e7o/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "校园一卡通"
        } 
    }
}
export default base
