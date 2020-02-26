/* auxiliaire*/
append([],X,X).
append([A|X],Y,[A|Result]):-
        append(X,Y,Result).

typeArgs([],[]).
typeArgs([(_,Type)|Rest],[Type | Result]):- 
        typeArgs(Rest,Result).

typeListExpressions(_, [],[]).
typeListExpressions(Context,[Expr|Rest],[Type|Result]):-
        typeExpression(Context,Expr,Type),
        typeListExpressions(Context,Rest,Result).

/*regle NUM*/
typeExpressionNum(Context,num(X),int).

/*regle SYM*/
typeExpressionSym([],K, undefined).
typeExpressionSym([(var(K),V)|T],var(K),V).
typeExpressionSym([(K,V)|T], K,V):-!.
typeExpressionSym([_|T],K,Result):-
        typeExpressionSym(T,K,Result).

/*regle ABS*/

typeExpressionAbs(Context, abs(Args,Corps), (TypeArgs,Type)):-
        append(Context,Args,New_Context),
        typeArgs(Args,TypeArgs),
        typeExpression(New_Context, Corps, Type).

/* régle APP */
typeExpressionApp(Context, app(Invoc, Exprs), Type):-
        typeListExpressions(Context,Exprs,Types),
        typeExpression(Context, Invoc, (Types,Type)).

/* regle IF */ 
typeExpressionIf(Context, if(Cond, Expr1, Expr2), Result):-
        typeExpression(Context, Cond, bool),
        typeExpression(Context, Expr1, Result),
        typeExpression(Context, Expr2, Result).  


/* regles Expr */

typeExpression(Context,num(X),Result):- typeExpressionNum(Context, num(X),Result), !.
typeExpression(Context,var(X),Result):- typeExpressionSym(Context, var(X),Result), !.
typeExpression(Context, abs(Args,Corps), Result):- typeExpressionAbs(Context, abs(Args,Corps), Result), !.
typeExpression(Context, app(Invoc,Exprs), Result):- typeExpressionApp(Context, app(Invoc,Exprs), Result), !.
typeExpression(Context, if(Cond, Expr1, Expr2), Result) :- typeExpressionIf(Context,if(Cond, Expr1, Expr2), Result), !.
typeExpression(Context,X,Result):- typeExpressionSym(Context, X,Result).
