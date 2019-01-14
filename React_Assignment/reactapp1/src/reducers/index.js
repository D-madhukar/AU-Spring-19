const rootReducer=(state={input:10},action)=>{
    if(action.type === 'click'){
        const newState={...state};
        newState.input++;
    }
    return newState;
}
export default rootReducer;