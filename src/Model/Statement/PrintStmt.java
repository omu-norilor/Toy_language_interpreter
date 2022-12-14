package Model.Statement;

import Model.ADT.MyDict;
import Model.ADT.SmartDict;
import Model.Expression.IExp;
import Exceptions.*;
import Model.ProgramState.ProgState;
import Model.Type.IType;
import Model.Value.IVal;

public class PrintStmt implements IStmt{
    IExp exp;

    public PrintStmt(IExp iExp) {
        exp=iExp;
    }

    @Override
    public ProgState execute(ProgState state) throws MyException {
        MyDict<String, IVal> symTbl= (MyDict<String, IVal>) state.getSymTable();
        SmartDict<Integer, IVal> heap = (SmartDict<Integer, IVal>) state.getHeap();
        state.getOut().add(exp.eval(symTbl,heap));
        return null;
    }

    @Override
    public MyDict<String, IType> typecheck(MyDict<String, IType> typeEnv) throws MyException {
        exp.typecheck(typeEnv);
        return  typeEnv;
    }

    @Override
    public String toString(){ return "print(" +exp.toString()+")";}
}
