import { nanoid } from "nanoid";
import axios from "axios";

export default {
  namespaced: true,
  state: {
    personList: [{ id: nanoid(), name: "张三" }],
  },
  getters: {
    firstPersonName(state) {
      return state.personList[0].name;
    },
  },
  actions: {
    addPerson(context, value) {
      context.commit("ADD_PERSON", value);
    },
    addPersonWithFeng(context, value) {
      if (value.name.indexOf("冯") == 0) {
        context.commit("ADD_PERSON", value);
      } else {
        alert("不是冯姓！");
      }
    },
    addWithAxios(context) {
      axios.get("https://api.uixsj.cn/hitokoto/get?type=social").then(
        (response) => {
          if (!response.data.trim()) return alert("请求数据为空！");
          context.commit("ADD_PERSON", { id: nanoid(), name: response.data });
        },
        (error) => {
          alert(error.message);
        }
      );
    },
  },
  mutations: {
    ADD_PERSON(state, value) {
      state.personList.unshift(value);
    },
  },
};
