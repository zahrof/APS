/*regle NUM*/
typeExpessionNum(Context,num(X),int).

/*regle SYM*/
typeExpessionSym([], K, undefined).
typeExpessionSym([(K,V)|T],var(K),V).
typeExpessionSym([(K,V)|T],K,V):-!.
typeExpessionSym([_|T],K,Result):-
        typeExpessionSym(T,K,Result).
