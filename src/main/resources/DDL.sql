create TABLE DEVELOPERS
(id int PRIMARY KEY,
name VARCHAR (50),
age int,
sex VARCHAR (10));

create TABLE SKILLS
(id int PRIMARY KEY,
language VARCHAR (50),
level VARCHAR (20));

create TABLE PROJECTS
(id int PRIMARY KEY,
project_name VARCHAR (255),
country VARCHAR (50);

create TABLE COMPANIES
(id int PRIMARY KEY,
name VARCHAR (100),
HRM VARCHAR (100));

create TABLE CUSTOMERS
(id int PRIMARY KEY,
name VARCHAR (100),
contact VARCHAR (50));

create TABLE DEVELOPERS_SKILLS
(developer_id int,
skill_id int,
PRIMARY KEY(developer_id, skill_id),
FOREIGN KEY (developer_id) REFERENCES DEVELOPERS(id),
FOREIGN KEY (skill_id) REFERENCES SKILLS(id));

create TABLE DEVELOPERS_PROJECTS
(developer_id int,
project_id int,
PRIMARY KEY(developer_id, project_id),
FOREIGN KEY (developer_id) REFERENCES DEVELOPERS(id),
FOREIGN KEY (project_id) REFERENCES PROJECTS(id));

create TABLE PROJECTS_COMPANIES
(project_id int,
company_id int,
PRIMARY KEY(project_id, company_id),
FOREIGN KEY (project_id) REFERENCES PROJECTS(id),
FOREIGN KEY (company_id) REFERENCES COMPANIES(id));

create TABLE PROJECTS_CUSTOMERS
(project_id int,
customer_id int,
PRIMARY KEY(project_id, customer_id),
FOREIGN KEY (project_id) REFERENCES PROJECTS(id),
FOREIGN KEY (customer_id) REFERENCES CUSTOMERS(id));

CREATE SEQUENCE developers_id_seq;
ALTER TABLE public.developers ALTER COLUMN id SET DEFAULT nextval('developers_id_seq');
ALTER SEQUENCE developers_id_seq OWNED BY public.developers.id;
SELECT setval('developers_id_seq', (SELECT max(id) FROM public.developers));

CREATE SEQUENCE skills_id_seq;
ALTER TABLE public.skills ALTER COLUMN id SET DEFAULT nextval('skills_id_seq');
ALTER SEQUENCE skills_id_seq OWNED BY public.skills.id;
SELECT setval('skills_id_seq', (SELECT max(id) FROM public.skills));

CREATE SEQUENCE projects_id_seq;
ALTER TABLE public.projects ALTER COLUMN id SET DEFAULT nextval('projects_id_seq');
ALTER SEQUENCE projects_id_seq OWNED BY public.projects.id;
SELECT setval('projects_id_seq', (SELECT max(id) FROM public.projects));

CREATE SEQUENCE companies_id_seq;
ALTER TABLE public.companies ALTER COLUMN id SET DEFAULT nextval('companies_id_seq');
ALTER SEQUENCE companies_id_seq OWNED BY public.companies.id;
SELECT setval('companies_id_seq', (SELECT max(id) FROM public.companies));

CREATE SEQUENCE customers_id_seq;
ALTER TABLE public.customers ALTER COLUMN id SET DEFAULT nextval('customers_id_seq');
ALTER SEQUENCE customers_id_seq OWNED BY public.customers.id;
SELECT setval('customers_id_seq', (SELECT max(id) FROM public.customers));

ALTER TABLE developers_projects
DROP CONSTRAINT developers_projects_project_id_fkey;

ALTER TABLE developers_projects
ADD CONSTRAINT dev_proj_id
foreign key (project_id) REFERENCES projects(id) ON DELETE CASCADE;

ALTER TABLE developers_projects
DROP CONSTRAINT developers_projects_developer_id_fkey;

ALTER TABLE developers_projects
ADD CONSTRAINT dev_proj_dev_id
foreign key (developer_id) REFERENCES developers(id) ON DELETE CASCADE;

ALTER TABLE developers_skills
DROP CONSTRAINT developers_skills_developer_id_fkey;

ALTER TABLE developers_skills
ADD CONSTRAINT dev_sk_dev_id
foreign key (developer_id) REFERENCES developers(id) ON DELETE CASCADE;

ALTER TABLE developers_skills
DROP CONSTRAINT developers_skills_skill_id_fkey;

ALTER TABLE developers_skills
ADD CONSTRAINT dev_sk_sk_id
foreign key (skill_id) REFERENCES skills(id) ON DELETE CASCADE;

ALTER TABLE PROJECTS_COMPANIES
DROP CONSTRAINT projects_companies_project_id_fkey;

ALTER TABLE PROJECTS_COMPANIES
ADD CONSTRAINT proj_com_proj_id
foreign key (project_id) REFERENCES projects(id) ON DELETE CASCADE;

ALTER TABLE PROJECTS_COMPANIES
DROP CONSTRAINT projects_companies_company_id_fkey;

ALTER TABLE PROJECTS_COMPANIES
ADD CONSTRAINT proj_com_comp_id
foreign key (company_id) REFERENCES companies(id) ON DELETE CASCADE;

ALTER TABLE PROJECTS_CUSTOMERS
DROP CONSTRAINT projects_customers_project_id_fkey;

ALTER TABLE PROJECTS_CUSTOMERS
ADD CONSTRAINT proj_cus_proj_id
foreign key (project_id) REFERENCES projects(id) ON DELETE CASCADE;

ALTER TABLE PROJECTS_CUSTOMERS
DROP CONSTRAINT projects_customers_customer_id_fkey;

ALTER TABLE PROJECTS_CUSTOMERS
ADD CONSTRAINT proj_cus_cust_id
foreign key (customer_id) REFERENCES customers(id) ON DELETE CASCADE;

ALTER TABLE projects ADD COLUMN date_of_creation DATE;

ALTER TABLE developers ADD COLUMN salary INT;

ALTER TABLE projects ADD COLUMN cost INT;
