export abstract class Compte {

    id: number;
    version: number;
    type:string;
    email:string;
    login:string;
    password:string;
    nom:string;
    prenom:string;
    pseudo:string; 
    biographie:string;
    
    constructor(id?:number, version?: number , type?: string, nom?: string, prenom?: string, email? :string,login?:string,password?:string,pseudo?:string, biographie?:string ) {
        this.id = id;
        this.version = version;
        this.login = login;
        this.password = password;
    }
}

export class Admin extends Compte {
 
    constructor(id?:number, version?: number, type?: string, nom?: string, prenom?: string, email? :string,login?:string,password?:string,pseudo?:string, biographie?:string) {
        super();

    }
}