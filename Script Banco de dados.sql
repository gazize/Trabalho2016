CREATE DATABASE SICM_WEB;

use SICM_WEB;

-- Criar tabela Aluno
Create Table Aluno(
  ALnome 		VarChar(60) Not Null,
  ALendereco 	VarChar(45) Not Null,
  ALtelefone 	VarChar(45) Not Null,
  ALemail 		VarChar(45) Not Null,
  ALrg 			VarChar(20) Not Null,
  ALcpf 		VarChar(14) Not Null,
  ALusuario 	VarChar(45) Not Null,
  ALd_e_l_e_t_ 	Int 		Not Null,
  ALRecno       Int         Not Null AUTO_INCREMENT,
  
  Primary Key (ALRecno)
);
  
-- Criar tabela Curso
Create Table Curso(
	CUCodigo 		VarChar(6) 	Not Null,
    CUDescricao		VarChar(30) Not Null,
    CUDataInicio	VarChar(10)  Not Null,
    CUDataFim		VarChar(10)  Not Null,
    CUHorario		VarChar(5)  Not Null,
	CUNumVagas		Int(5)	    Not Null,
    CUArea			VarChar(1)  Not Null,
    CUValor			Decimal(20,5) Not Null,
    CUD_e_l_e_t_	Int(1)		Not Null,
    CURecno       Int         Not Null AUTO_INCREMENT,
    Primary Key(CURecno)
);

-- Criar tabela CursoInformatica
Create Table CursoInformatica(
	CUILaboratorio	VarChar(6)  Not Null,
    CUICodigoCurso	VarChar(6)  Not Null,
    CUIRegistros	VarChar(50) Not Null,
	CUIDe_l_e_t_	Int(1)		Not Null,
    CUIRecno	    Int         Not Null AUTO_INCREMENT,
    
    Primary Key(CUIRecno)
);    
    
 -- Criar tabela CursoArtes   
 Create Table CursoArtes(

	CUACodigoCurso VarChar(6)  Not Null ,
    CUAMaterial    VarChar(40),
    CUALivro       VarChar(40),
    CUARecno	   Int         Not Null AUTO_INCREMENT,
    CUAD_e_l_e_t_  Int(1)      Not Null, 
    
    Primary Key(CUARecno)

);

Create Table Matricula(

	MATCodMatricula VarChar(6)  	Not Null,
    MATCodAluno 	VarChar(14) 	Not Null,
    MATCodCurso		VarChar(6)  	Not Null,
    MATValor		Decimal(20,5) 	Not Null,
    MATData			VarChar(10)		Not Null,
    MATStatusPgto   VarChar(1)		Not Null,
    MATStatusMatr	VarChar(1)		Not Null,
    MATD_e_l_e_t_   Int(1)			Not Null,
    MATRecno		Int				Not Null AUTO_INCREMENT,
    
    primary key(MATRecno)

);
