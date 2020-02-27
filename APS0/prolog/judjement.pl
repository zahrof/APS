/* Relations auxilliaire */

/* Concatenation de deux listes */
append([],X,X).
append([A|X],Y,[A|Result]):-
        append(X,Y,Result).
/* Verification si le cle K exitste dans contexte. 
Si existe on retourne le type associe, sinon undefined*/
lookup([],_,undefined).
lookup([(K,V)|_], K, V).
lookup([_|T], K, Result):-
        lookup(T,K,Result).
/* Renvoie la liste de types des arguments. Par exemple:
   [x:int,y:int,z:bool] -> [int,int,bool]*/
typeArgs([],[]).
typeArgs([(_,Type)|Rest],[Type | Result]):- 
        typeArgs(Rest,Result).
/* Renvoie la liste de types des expressions. Par exemple:
   [num(1),true,num(5)] -> [int,bool,int]*/
typeListExpressions(_, [],[]).
typeListExpressions(Context,[Expr|Rest],[Type|Result]):-
        typeExpression(Context,Expr,Type),
        typeListExpressions(Context,Rest,Result).
/* Context initial */
context_init([ (add,([int,int],int)), 
               (sub,([int,int],int)), 
               (mul,([int,int],int)), 
               (div,([int,int],int)),
               (and,([bool,bool],bool)),
               (or,([bool,bool],bool)),
               (not,([bool],bool)),
               (eq,([int,int],bool)),
               (lt,([int,int],bool)),
               (true,bool),
               (false,bool) ]).

/* Typage d'expressions */

/* regle NUM */
typeExpression(_,num(_),int):- !.
/* regle SYM (pour var) */
typeExpression(Context, var(Var), Result):-
        lookup(Context,Var,Result), !.
/*regle ABS*/
typeExpression(Context, abs(Args,Corps), (TypeArgs,Type)):-
        append(Args,Context,New_Context),
        typeArgs(Args,TypeArgs),
        typeExpression(New_Context, Corps, Type), !.
/* régle APP */
typeExpression(Context, app(Invoc,Exprs), Type):-
        typeListExpressions(Context,Exprs,Types),
        typeExpression(Context, Invoc, (Types,Type)), !.
/* regle IF */ 
typeExpression(Context, if(Cond,Expr1,Expr2), Result):-
        typeExpression(Context, Cond, bool),
        typeExpression(Context, Expr1, Result),
        typeExpression(Context, Expr2, Result), !.  
/* regle SYM (pour oprim) ou undefined (pour expression mal typé) */
typeExpression(Context, X, Result):-
        lookup(Context,X,Result), !.

/* Typage de statements */

/* regle ECHO */
typeStatement(Context, echo(Expr), void):-
        typeExpression(Context, Expr, int), !.

/* Typage de declarations */

/* regle CONST */
typeDeclaration(Context, const(Var,Type,Expr), New_Context):-
        typeExpression(Context, Expr, Type),
        append([(Var,Type)],Context, New_Context), !.
/* regle FUNC */
typeDeclaration(Context, func(Var,Type,Args,Expr), New_Context):-
        append(Args,Context,FuncContext),
        typeExpression(FuncContext,Expr,Type),
        typeArgs(Args,TypeArgs),
        append([(Var,(TypeArgs,Type))], Context, New_Context), !.
/* regle FUNCREC */        
typeDeclaration(Context, func_rec(Var,Type,Args,Expr), New_Context):-
        typeArgs(Args,TypeArgs),
        append([(Var,(TypeArgs, Type)) | Args],Context,FuncRecContext),
        typeExpression(FuncRecContext,Expr,Type),
        append([(Var,(TypeArgs,Type))], Context, New_Context), !.

/* Typage de commandes */

/* regle END */
typeCommands(_, [], void).
/* regle STATS */
typeCommands(Context, [Stat|Cmds], void):-
        typeStatement(Context, Stat, void),
        typeCommands(Context, Cmds, void).
/* regle DECS */
typeCommands(Context, [Dec|Cmds], void):-
        typeDeclaration(Context, Dec, New_Context),
        typeCommands(New_Context, Cmds, void).

/* Typage du programme */
typeProgram(prog(Cmds)):-
        context_init(Context0),
        typeCommands(Context0, Cmds, void), !.