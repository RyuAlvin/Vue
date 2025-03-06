export default {
  changeMessageInRightWay(context, payload) {
    setTimeout(() => {
      console.log('username ===> ', payload.username);
      console.log('role ===> ', payload.role);
      context.commit('changeMessageInRightWay');

      // 异步处理结束后通知
      payload.success();
    }, 1000);
  },
  usePromise(context, payload) {
    return new Promise((resolve) => {
      setTimeout(() => {
        console.log('actions ===> username ===> ', payload.username);
        console.log('actions ===> role ===> ', payload.role);
        context.commit('usePromise');

        resolve('处理完成啦！')
      }, 1000);
    })
  }
}