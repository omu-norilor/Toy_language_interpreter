package Model.Expression;

import Model.ADT.MyDict;
import Exceptions.*;
import Model.ADT.SmartDict;
import Model.Type.IType;
import Model.Value.IVal;

public interface IExp {
    IVal eval(MyDict<String,IVal> tbl, SmartDict<Integer,IVal> hp) throws MyException;

    IType typecheck(MyDict<String,IType> typeEnv) throws MyException;
}
