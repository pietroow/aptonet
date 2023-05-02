import * as DemoActions from './../actions/demo.actions';

const initialState: any = {
  lastClicked: -1,
  demos: [
    {
      name: 'Harisudhan',
      gender: 'Male',
    },
  ],
};

export function reducer(
  state: any = initialState,
  action: DemoActions.Actions
) {
  switch (action.type) {
    case DemoActions.ADD_DEMO:
      state.demos.push(action.payload);
      return state;
    case DemoActions.REMOVE_DEMO:
      state.splice(action.payload, 1);
      return state;
    case DemoActions.UPDATE_DEMO:
      state.demos[state.lastClicked] = action.payload;
      return state;
    case DemoActions.LAST_SELECTED:
      state.lastClicked = action.payload;
      const res = { ...state };
      return res;
    default:
      return state;
  }
}
